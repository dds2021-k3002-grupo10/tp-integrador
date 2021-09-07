package com.disenio.controller.caracteristicas;

import com.disenio.model.Views;
import com.disenio.model.caracteristicas.Caracteristica;
import com.disenio.services.caracteristicas.CaracteristicaService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {
    private static final Logger LOGGER = Logger.getLogger(CaracteristicaController.class);
    @Autowired
    private CaracteristicaService caracteristicaService;

    @PostMapping("/guardar")
    public ResponseEntity alta(HttpServletRequest request, @RequestBody Caracteristica caracteristica) {
        ResponseEntity response;
        try {
            caracteristicaService.alta(caracteristica);
            response = new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
            LOGGER.error("Ocurrio un error al dar de Alta una caracterstica", e);
        }
        return response;
    }

    @RequestMapping(value = "/organizacion/{idOrganizacion}", method = RequestMethod.GET)
    @JsonView(Views.External.class)
    public ResponseEntity<List<Caracteristica>> getCaracteristicaAll(@PathVariable("idOrganizacion") Integer idOrganizacion ) {
        ResponseEntity<List<Caracteristica>> response;

        List<Caracteristica> caracteristicas = caracteristicaService.getCaracteristicaByOrganizacionId(idOrganizacion);
        if (caracteristicas.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(caracteristicas);
        }
        return response;

    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    @JsonView(Views.External.class)
    public ResponseEntity<List<Caracteristica>> getCaracteristicaAll() {
        ResponseEntity<List<Caracteristica>> response;

        List<Caracteristica> caracteristicas = caracteristicaService.getCaracteristicaAll();
        if (caracteristicas.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(caracteristicas);
        }
        return response;

    }



}
