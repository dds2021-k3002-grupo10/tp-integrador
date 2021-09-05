package com.disenio.rest.resources.caracteristicas;

import com.disenio.entities.Views;
import com.disenio.entities.caracteristicas.ComportamientoTipo;
import com.disenio.services.caracteristicas.ComportamientoTipoService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comportamiento-tipo")
public class ComportamientoResource {
    @Autowired
    private ComportamientoTipoService comportamientoTipoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @JsonView(Views.External.class)
    public ResponseEntity<List<ComportamientoTipo>> getComportamientoTipoAll() {
        ResponseEntity<List<ComportamientoTipo>> response;

        List<ComportamientoTipo> comportamientoTipos = comportamientoTipoService.getComportamientoTipoAll();
        if (comportamientoTipos.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(comportamientoTipos);
        }
        return response;

    }
}
