package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.publicacion.DTOPublicacionAdoptante;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionAdopcion;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.factory.Factory;
import com.disenio.services.publicaciones.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/publicaciones/adopciones/adoptar")
public class PublicacionAdoptanteController {


    @Autowired
    private PublicacionService publicacionService;

    @Autowired
    private Factory<PublicacionAdoptante, DTOPublicacionAdoptante> factory;

    @PostMapping(path = "/guardar")
    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionAdoptante dtoPublicacion) {
        DTOResponse dtoResponse = new DTOResponse();
        ResponseEntity<DTOResponse> response;
        PublicacionAdoptante publicacion;
        try {
            publicacion = factory.createFromDTO(dtoPublicacion);
            publicacionService.alta(publicacion);
            //TODO Agregar en la organizacion!
            dtoResponse.setStatus(HttpStatus.CREATED);
            dtoResponse.setMsg("Se creo la publicacion satisfactoriamente");
            response = new ResponseEntity(dtoResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            dtoResponse.setMsg("No se pudo crear la publicacion");
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            response = new ResponseEntity(dtoResponse, HttpStatus.NO_CONTENT);
        }

        return response;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOResponse> getPublicacionAdptanteID(@PathVariable("id") Integer id, HttpServletRequest request) {
        DTOResponse dtoResponse = new DTOResponse();

        PublicacionAdoptante publicacion = (PublicacionAdoptante) publicacionService.getById(id).orElseGet(null);
        DTOPublicacionAdoptante dtoPublicacion = new DTOPublicacionAdoptante(publicacion);
        //TODO: Se debe hacer la verificacion de la organizacion!
        dtoResponse.setStatus(HttpStatus.OK);
        dtoResponse.setData(dtoPublicacion);
        return ResponseEntity.ok(dtoResponse);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<DTOResponse> getPublicacionDarAdopcionAll() {
        DTOResponse response = new DTOResponse();
        List<PublicacionAdoptante> publicaciones = publicacionService.listarAdoptante();
        List<DTOPublicacionAdoptante> dtoPublicaciones;

        dtoPublicaciones = publicaciones.stream()
                .map(DTOPublicacionAdoptante::new)
                .collect(Collectors.toList());

        response.setStatus(HttpStatus.OK);
        response.setData(dtoPublicaciones);


        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/notificar/{id}")
    public ResponseEntity<DTOResponse> getPublicacionesPerdidasByID(@PathVariable("id") Integer id, HttpServletRequest request) {

        DTOResponse dtoResponse = new DTOResponse();
        ResponseEntity<DTOResponse> response;
        try {
            Publicacion publicacionS = publicacionService.getById(id).orElseGet(null);
            if (publicacionS != null && publicacionS instanceof PublicacionAdoptante) {
                dtoResponse.setMsg("No existe la publicacion");
                PublicacionAdoptante publicacion = (PublicacionAdoptante) ((PublicacionAdopcion) publicacionS);
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                if (usuario == null) {
                    dtoResponse.setMsg("Debe estar logueado");
                }
                Persona persona = usuario.getPersona();
                Persona autor = publicacion.getAutor();
                if (persona == null) {
                    dtoResponse.setMsg("Este usuario no tiene persona!");
                }
                dtoResponse.setMsg("Se notifica!");
                List<PersonaContacto> personas = persona.getPersonaContactos();
                autor.notificar("Te contamos que " + persona.getNombre() + " te quiere contactar para ofrecerte una mascota acorde a tus necesidades. Llamar a " + personas.get(0).getTelefono() + "(" + persona.getNombre() + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
            dtoResponse.setData(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(dtoResponse);
    }
}

