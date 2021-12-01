package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.publicacion.DTOPublicacionDarAdopcion;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
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
}
