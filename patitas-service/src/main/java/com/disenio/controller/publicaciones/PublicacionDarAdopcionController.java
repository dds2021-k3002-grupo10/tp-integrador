package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.publicacion.DTOPublicacionDarAdopcion;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.factory.Factory;
import com.disenio.services.mascotas.MascotasService;
import com.disenio.services.personas.PersonaService;
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
@RequestMapping("/publicaciones/adopciones/dar")
public class PublicacionDarAdopcionController {


    @Autowired
    private PublicacionService publicacionService;

    @Autowired
    private MascotasService mascotasService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private Factory<PublicacionDarAdopcion, DTOPublicacionDarAdopcion> factory;

    @PostMapping(path = "/guardar")

    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionDarAdopcion dtoPublicacion) {

        DTOResponse dtoResponse = new DTOResponse();
        ResponseEntity<DTOResponse> response;
        PublicacionDarAdopcion publicacion;

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
    public ResponseEntity<DTOResponse> getPublicacionDarAdopcionByID(@PathVariable("id") Integer id) {
        DTOResponse dtoResponse = new DTOResponse();

        PublicacionDarAdopcion publicacion = (PublicacionDarAdopcion) publicacionService.getById(id).orElseGet(null);
        DTOPublicacionDarAdopcion dtoPublicacion = new DTOPublicacionDarAdopcion(publicacion);

        if (dtoPublicacion.getMascota() == null || dtoPublicacion.getAutor() == null) {
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            dtoResponse.setMsg("No existen publicacion.");
            return ResponseEntity.ok(dtoResponse);
        }
        dtoResponse.setStatus(HttpStatus.OK);
        dtoResponse.setData(dtoPublicacion);
        return ResponseEntity.ok(dtoResponse);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<DTOResponse> getPublicacionDarAdopcionAll() {
        DTOResponse response = new DTOResponse();
        List<PublicacionDarAdopcion> publicaciones = publicacionService.listarDarAdopcion();
        List<DTOPublicacionDarAdopcion> dtoPublicaciones;

        dtoPublicaciones = publicaciones.stream()
                .map(DTOPublicacionDarAdopcion::new)
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
            if (publicacionS != null && publicacionS instanceof PublicacionDarAdopcion) {
                dtoResponse.setMsg("No existe la publicacion");
            }
            PublicacionDarAdopcion publicacion = (PublicacionDarAdopcion) publicacionS;
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            if (usuario == null) {
                dtoResponse.setMsg("Debe estar logueado");
                Persona persona = usuario.getPersona();
                Persona autor = publicacion.getAutor();
                if (persona == null) {
                    dtoResponse.setMsg("Este usuario no tiene persona!");
                }
                dtoResponse.setMsg("Se notifica!");
                List<PersonaContacto> personas = persona.getPersonaContactos();
                autor.notificar("Te contamos que " + persona.getNombre() + " te quiere contactar para adoptar a tu mascota " + publicacion.getMascotaOfrecida().getNombre() + ". Llamar a " + personas.get(0).getTelefono() + "(" + persona.getNombre() + ")");
            }

        } catch (Exception e) {
            e.printStackTrace();
            dtoResponse.setData(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(dtoResponse);
    }
}
