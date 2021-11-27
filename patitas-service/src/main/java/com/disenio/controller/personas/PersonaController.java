package com.disenio.controller.personas;

import com.disenio.dto.persona.PersonaDTO;
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
    public ResponseEntity<Persona> alta(HttpServletRequest request, @RequestBody Persona persona) {
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
    public ResponseEntity<List<PersonaDTO>> getPersonasAll() {
        ResponseEntity<List<PersonaDTO>> response;

        List<PersonaDTO> personasDTO = personaService.getListaAllPersona();
        if (personasDTO.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(personasDTO);
        }
        return response;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PersonaDTO> getPersonasDTOById(@PathVariable("id") Integer id) {

        PersonaDTO personasDTO = personaService.getPersonaDTOById(id);
        if (personasDTO != null) {
            return ResponseEntity.ok(personasDTO);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    /*Buscar persona por tipo y nro de documento*/
    @RequestMapping(value = "/buscarByDoc", method = RequestMethod.GET)
    public ResponseEntity<List<PersonaDTO>> getPersonasByCondicion(
            @RequestParam(required = true) Integer idTipoDoc,
            @RequestParam(required = true) Integer numero ) {

        List<PersonaDTO> personasDTO =  personaService.getPersonasByCondicion(idTipoDoc,numero);
        if (!personasDTO.isEmpty()) {
            return ResponseEntity.ok(personasDTO);
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
