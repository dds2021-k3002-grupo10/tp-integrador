package com.disenio.services.personas.impl;

import com.disenio.repositoryDAO.PersonaDAO;
import com.disenio.model.personas.Persona;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service()
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    @Qualifier("PersonaDAO")
    private PersonaDAO personaDAO;

    @Transactional
    @Override
    public Persona alta(Persona persona) {

        return personaDAO.save(persona);

    }

    @Override
    public List<Persona> getListaAllPersona() {

        return personaDAO.findAll();
    }

    @Override
    public Optional<Persona> getPersonasById(Integer id) {
        Optional<Persona> persona = personaDAO.findById(id);

        return persona;
    }

}
