package com.disenio.rest.resources.caracteristicas;

import com.disenio.entities.Views;
import com.disenio.entities.caracteristicas.Caracteristica;
import com.disenio.services.comportamiento.CaracteristicaService;
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
public class CaracteristicaResource {
    private static final Logger LOGGER = Logger.getLogger(CaracteristicaResource.class);
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
