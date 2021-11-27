package com.disenio.controller.personas;

import com.disenio.model.personas.MedioNotificacion;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.TipoDocumento;
import com.disenio.services.personas.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private static final Logger LOGGER = Logger.getLogger(PersonaController.class);

    @Autowired
    private PersonaService personaService;
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    private MedioNotificacionService MedioNotificacionService;


    //@PostMapping("")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Persona> guardar(HttpServletRequest request, @RequestBody Persona persona) {
        ResponseEntity response;
        try {
            personaService.alta(persona);

            //response= new ResponseEntity(rtaPersona, HttpStatus.CREATED);
            response = new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity(e, HttpStatus.BAD_REQUEST);
            LOGGER.error("Ocurrio un error al dar de Alta", e);
        }
        return response;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> getPersonasAll() {
        ResponseEntity<List<Persona>> response;

        List<Persona> personas = personaService.getListaAllPersona();
        if (personas.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(personas);
        }
        return response;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Persona> getPersonasById(@PathVariable("id") Integer id) {

        Optional<Persona> personas = personaService.getPersonasById(id);
        if (personas.isPresent()) {
            return ResponseEntity.ok(personas.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*Buscar persona por tipo y nro de documento*/
    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> getPersonasByCondicion(
            @PathVariable("idTipoDoc") Integer idTipoDoc, @PathVariable("numero") Integer numero
    ) {

        List<Persona> personas = null;// personaService.getPersonasById(null;id);
        if (personas.isEmpty()) {
            return ResponseEntity.ok(personas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*tipo de documento trae All*/
    @RequestMapping(value = "/tipo-documento", method = RequestMethod.GET)
    public ResponseEntity<List<TipoDocumento>> getTipoDocumentoAll() {
        ResponseEntity<List<TipoDocumento>> response;

        List<TipoDocumento> rtaTipoDocumento = tipoDocumentoService.getTipoDocuemntoALl();
        if (rtaTipoDocumento.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(rtaTipoDocumento);
        }
        return response;
    }

    /*Medio de notificacion trae All*/
    @RequestMapping(value = "/medio-notificacion", method = RequestMethod.GET)
    public ResponseEntity<List<MedioNotificacion>> getMedioNotificacionAll() {
        ResponseEntity<List<MedioNotificacion>> response;

        List<MedioNotificacion> rtaMedioNotificacion = MedioNotificacionService.getMedioNotificacionALl();
        if (rtaMedioNotificacion.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(rtaMedioNotificacion);
        }
        return response;
    }
}
