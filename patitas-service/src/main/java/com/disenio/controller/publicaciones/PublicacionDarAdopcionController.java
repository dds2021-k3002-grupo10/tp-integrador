package com.disenio.controller.publicaciones;

import com.disenio.model.Views;
import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.services.publicaciones.PublicacionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publicaciones/adopciones/dar")
public class PublicacionDarAdopcionController {


    @Autowired
    private PublicacionService publicacionService;


    @PostMapping(path = "/guardar")
    public ResponseEntity<PublicacionAdoptante> guardar(HttpServletRequest request, @RequestBody PublicacionAdoptante publicacion) {
        //TODO Potencial DTO?
        return new ResponseEntity(publicacionService.alta(publicacion), HttpStatus.CREATED);
    }

    /* TODO :Terminar eliminar
    @DeleteMapping(path = "/borrar")
    public ResponseEntity<PublicacionPerdida> guardar(HttpServletRequest request, @RequestBody PublicacionPerdida publicacion) {
        return new ResponseEntity(publicacionService.alta(publicacion), HttpStatus.CREATED);
    }
    */

    @JsonView(Views.External.class)
    @GetMapping(path = "/{id}")
    public ResponseEntity<List<PublicacionAdoptante>> getPublicacionDarAdopcionByID(@PathVariable("id") Integer id) {
        ResponseEntity<List<PublicacionAdoptante>> response;

        Optional<Publicacion> publicaciones = publicacionService.getById(id);

        response = publicaciones.map(publicacion -> ResponseEntity.ok((List<PublicacionAdoptante>) publicacion)).orElseGet(() -> ResponseEntity.noContent().build());
        return response;
    }


    @JsonView(Views.External.class)
    @GetMapping(path = "/all")
    public ResponseEntity<List<PublicacionAdoptante>> getPublicacionDarAdopcionAll() {
        ResponseEntity<List<PublicacionAdoptante>> response;

        List<PublicacionAdoptante> publicacion = publicacionService.listarAdoptante();

        if (publicacion.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(publicacion);
        }
        return response;
    }
}
