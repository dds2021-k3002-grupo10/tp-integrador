package com.disenio.controller.personas;

import com.disenio.model.Views;
import com.disenio.model.personas.Persona;
import com.disenio.services.personas.PersonaService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController {


    @Autowired
    private PersonaService personaService;


    //@PostMapping("")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Persona> guardar(HttpServletRequest request, @RequestBody Persona persona) {
        Persona rtaPersona = personaService.alta(persona);
        return new ResponseEntity(personaService.alta(persona), HttpStatus.CREATED);

        // response;
    }
    @JsonView(Views.External.class)
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
    @JsonView(Views.External.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Persona> getPersonasById(@PathVariable("id") Integer id) {

        Optional<Persona> personas = personaService.getPersonasById(id);
        if (personas.isPresent()) {
            return ResponseEntity.ok(personas.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}
