package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.persona.DTOPersona;
import com.disenio.dto.publicacion.DTOPublicacionAdoptante;
import com.disenio.dto.publicacion.DTOPublicacionDarAdopcion;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.publicaciones.PublicacionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publicaciones/adopciones/adoptar")
public class PublicacionAdoptanteController {


    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private PersonaService personaService;

    @PostMapping(path = "/guardar")
    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionDarAdopcion dtoPublicacion) {
        DTOPersona dtoPersona = dtoPublicacion.getAutor();
        DTOResponse dtoResponse = new DTOResponse();

        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);

        PublicacionAdoptante publicacion = new PublicacionAdoptante(persona, dtoPublicacion.getDescripcion());

        if (persona == null) {
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            dtoResponse.setMsg("No existe persona");
            return new ResponseEntity(dtoResponse, HttpStatus.NO_CONTENT);
        }
        publicacionService.alta(publicacion);

        dtoResponse.setStatus(HttpStatus.CREATED);
        dtoResponse.setMsg("Se creo la publicacion satisfactoriamente");
        return new ResponseEntity(dtoResponse, HttpStatus.CREATED);
    }

    /* TODO :Terminar eliminar
    @DeleteMapping(path = "/borrar")
    public ResponseEntity<PublicacionPerdida> guardar(HttpServletRequest request, @RequestBody PublicacionPerdida publicacion) {
        return new ResponseEntity(publicacionService.alta(publicacion), HttpStatus.CREATED);
    }
    */


    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOResponse> getPublicacionAdptanteID(@PathVariable("id") Integer id) {
        DTOResponse dtoResponse = new DTOResponse();

        PublicacionAdoptante publicacion = (PublicacionAdoptante) publicacionService.getById(id).orElseGet(null);
        DTOPublicacionAdoptante dtoPublicacion = new DTOPublicacionAdoptante(publicacion);

        if (dtoPublicacion.getAutor() == null) {
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
        List<PublicacionAdoptante> publicaciones = publicacionService.listarAdoptante();
        List<DTOPublicacionAdoptante> dtoPublicaciones;

        dtoPublicaciones = publicaciones.stream()
                .map(DTOPublicacionAdoptante::new)
                .collect(Collectors.toList());

        response.setStatus(HttpStatus.OK);
        response.setData(dtoPublicaciones);


        return ResponseEntity.ok(response);
    }
}

