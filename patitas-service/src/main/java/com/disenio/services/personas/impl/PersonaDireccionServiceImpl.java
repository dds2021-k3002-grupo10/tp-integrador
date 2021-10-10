package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaContactoDAO;
import com.disenio.dao.persona.PersonaDireccionDAO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDireccion;
import com.disenio.services.personas.PersonaDireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaDireccionServiceImpl implements PersonaDireccionService {
    @Autowired
    private PersonaDireccionDAO personaDireccionDAO;

    @Transactional
    @Override
    public void alta(List<PersonaDireccion> personaDireccions, Persona persona) {

        personaDireccions.forEach(personaDireccion -> {

            personaDireccion.setPersona(persona);
            //AltaPersonasContacto
            personaDireccionDAO.save(personaDireccion);

        });
    }
}
