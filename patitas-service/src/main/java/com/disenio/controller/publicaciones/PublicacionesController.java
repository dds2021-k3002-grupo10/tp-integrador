package com.disenio.controller.publicaciones;

import com.disenio.model.Views;
import com.disenio.model.publicaciones.Estado;
import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.publicaciones.PublicacionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionesController {

    @Autowired
    private PublicacionService publicacionService;

    @RequestMapping(value = "/guardar", method = RequestMethod.GET)
    //public ResponseEntity<Publicacion> guardar(HttpServletRequest request, @RequestBody Publicacion publicacion) {
    public ResponseEntity<Publicacion> guardar() {
        /*MOCK*/
        PublicacionPerdida publicacion1 = new PublicacionPerdida();
        publicacion1.setEstado(Estado.APROBADO);
        publicacion1.setFecha(Date.from(Instant.now()));



        return new ResponseEntity(publicacionService.alta(publicacion1), HttpStatus.CREATED);

    }

    @JsonView(Views.External.class)
    @RequestMapping(value = "/perdidas/all", method = RequestMethod.GET)
    public ResponseEntity<List<PublicacionPerdida>> getPublicacionesAll() {
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
