package com.disenio.services.impl;

import com.disenio.dao.PersonaDAO;
import com.disenio.models.personas.Persona;
import com.disenio.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("PersonaService")
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
    public Optional<Persona> getPersonasById(Long id) {
        Optional<Persona> persona = personaDAO.findById(id);

        return persona;
    }

}
