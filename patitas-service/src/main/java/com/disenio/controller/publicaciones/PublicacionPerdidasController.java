package com.disenio.controller.publicaciones;

import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionPerdida;
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
@RequestMapping("/publicaciones/perdidas")
public class PublicacionPerdidasController {
    @Autowired
    private PublicacionService publicacionService;


    @PostMapping(path = "/guardar")
    public ResponseEntity<PublicacionPerdida> guardar(HttpServletRequest request, @RequestBody PublicacionPerdida publicacion) {
        //TODO Potencial DTO?
        return new ResponseEntity(publicacionService.alta(publicacion), HttpStatus.CREATED);
    }

    /* TODO :Terminar eliminar
    @DeleteMapping(path = "/borrar")
    public ResponseEntity<PublicacionPerdida> guardar(HttpServletRequest request, @RequestBody PublicacionPerdida publicacion) {
        return new ResponseEntity(publicacionService.alta(publicacion), HttpStatus.CREATED);
    }
    */

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<PublicacionPerdida>> getPublicacionesPerdidasByID(@PathVariable("id") Integer id) {
        ResponseEntity<List<PublicacionPerdida>> response;

        Optional<Publicacion> publicaciones = publicacionService.getById(id);

        response = publicaciones.map(publicacion -> ResponseEntity.ok((List<PublicacionPerdida>) publicacion)).orElseGet(() -> ResponseEntity.noContent().build());
        return response;
    }


    @GetMapping(path = "/all")
    public ResponseEntity<List<PublicacionPerdida>> getPublicacionesPerdidasAll() {
        ResponseEntity<List<PublicacionPerdida>> response;

        List<PublicacionPerdida> publicacion = publicacionService.listarPerdidas();

        if (publicacion.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(publicacion);
        }
        return response;
    }
}
