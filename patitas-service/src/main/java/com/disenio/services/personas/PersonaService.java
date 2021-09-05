package com.disenio.services.personas;

import com.disenio.entities.personas.Persona;

import java.util.List;
import java.util.Optional;


public interface PersonaService {

    Persona alta(Persona persona);

    List<Persona> getListaAllPersona();

    Optional<Persona> getPersonasById(Integer id);

}
