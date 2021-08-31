package com.disenio.services;

import com.disenio.models.personas.Persona;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface PersonaService {

   public abstract Persona alta( Persona persona ) ;

    public abstract List<Persona> getListaAllPersona( ) ;

    public abstract Optional<Persona> getPersonasById(Long id) ;

    }
