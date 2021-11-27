package com.disenio.controller.publicaciones;

import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
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
@RequestMapping("/publicaciones/adopciones/adoptar")
public class PublicacionAdoptanteController {


    @Autowired
    private PublicacionService publicacionService;


    @PostMapping(path = "/guardar")
    public ResponseEntity<PublicacionDarAdopcion> guardar(HttpServletRequest request, @RequestBody PublicacionDarAdopcion publicacion) {
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
    public ResponseEntity<List<PublicacionDarAdopcion>> getPublicacionDarAdopcionByID(@PathVariable("id") Integer id) {
        ResponseEntity<List<PublicacionDarAdopcion>> response;

        Optional<Publicacion> publicaciones = publicacionService.getById(id);

        response = publicaciones.map(publicacion -> ResponseEntity.ok((List<PublicacionDarAdopcion>) publicacion)).orElseGet(() -> ResponseEntity.noContent().build());
        return response;
    }


    @GetMapping(path = "/all")
    public ResponseEntity<List<PublicacionDarAdopcion>> getPublicacionDarAdopcionAll() {
        ResponseEntity<List<PublicacionDarAdopcion>> response;

        List<PublicacionDarAdopcion> publicacion = publicacionService.listarDarAdopcion();

        if (publicacion.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(publicacion);
        }
        return response;
    }
}
