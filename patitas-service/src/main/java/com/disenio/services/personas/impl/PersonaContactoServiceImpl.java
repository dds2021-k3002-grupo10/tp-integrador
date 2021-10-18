package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaContactoDAO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.services.personas.PersonaContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaContactoServiceImpl implements PersonaContactoService {

    @Autowired
    private PersonaContactoDAO personaContactoDAO;

    @Transactional
    @Override
    public void alta(List<PersonaContacto> personaContactos, Persona persona) {
        personaContactos.forEach(personaContacto -> {

            personaContacto.setPersona(persona);
            //AltaPersonasContacto
            personaContactoDAO.save(personaContacto);

        });
    }
}
