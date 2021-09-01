package com.disenio.services;

import com.disenio.entities.personas.Persona;

import java.util.List;
import java.util.Optional;


public interface PersonaService {

   public abstract Persona alta( Persona persona ) ;

    public abstract List<Persona> getListaAllPersona( ) ;

    public abstract Optional<Persona> getPersonasById(Long id) ;

    }
