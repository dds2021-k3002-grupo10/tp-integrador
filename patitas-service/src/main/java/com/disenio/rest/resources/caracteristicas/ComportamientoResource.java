package com.disenio.rest.resources.caracteristicas;

import com.disenio.entities.caracteristicas.ComportamientoTipo;
import com.disenio.entities.personas.Persona;
import com.disenio.services.comportamiento.ComportamientoTipoService;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comportamiento")
public class ComportamientoResource {
    @Autowired
    private ComportamientoTipoService comportamientoTipoService;

    @RequestMapping(value = "/tipo", method = RequestMethod.GET)
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
