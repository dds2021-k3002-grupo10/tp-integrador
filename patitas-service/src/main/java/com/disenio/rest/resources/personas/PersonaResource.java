package com.disenio.rest.resources.personas;

import com.disenio.entities.personas.Persona;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaResource {


    @Autowired
    private PersonaService personaService;


    @PostMapping("/guardar")
    public ResponseEntity<Persona> guardar(HttpServletRequest request, @RequestBody Persona persona) {

        return new ResponseEntity(personaService.alta(persona), HttpStatus.CREATED);

        // response;
    }

    @RequestMapping(value = "/getLista", method = RequestMethod.GET)
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

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Persona> getPersonasById(@PathVariable("id") Long id) {
        System.out.println(id);
        Optional<Persona> personas = personaService.getPersonasById(id);
        if (personas.isPresent()) {
            return ResponseEntity.ok(personas.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }
}
