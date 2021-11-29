package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.mascota.DTOMascota;
import com.disenio.dto.persona.DTOPersona;
import com.disenio.dto.publicacion.DTOPublicacionDarAdopcion;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.services.mascotas.MascotasService;
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
@CrossOrigin
@RequestMapping("/publicaciones/adopciones/dar")
public class PublicacionDarAdopcionController {


    @Autowired
    private PublicacionService publicacionService;

    @Autowired
    private MascotasService mascotasService;

    @Autowired
    private PersonaService personaService;

    @PostMapping(path = "/guardar")
    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionDarAdopcion dtoPublicacion) {
        DTOPersona dtoPersona = dtoPublicacion.getAutor();
        DTOMascota dtoMascota = dtoPublicacion.getMascota();
        DTOResponse dtoResponse = new DTOResponse();

        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);
        Mascota mascota = mascotasService.getById(dtoMascota.getIdMascota()).orElse(null);

        PublicacionDarAdopcion publicacion = new PublicacionDarAdopcion(persona, mascota, dtoPublicacion.getDescripcion());

        if (mascota == null || persona == null) {
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            dtoResponse.setMsg("No se pudo crear la publicacion");
            return new ResponseEntity(dtoResponse, HttpStatus.NO_CONTENT);
        }
        publicacionService.alta(publicacion);
        dtoResponse.setStatus(HttpStatus.CREATED);
        dtoResponse.setMsg("Se creo la publicacion satisfactoriamente");
        return new ResponseEntity(dtoResponse, HttpStatus.CREATED);
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
}
