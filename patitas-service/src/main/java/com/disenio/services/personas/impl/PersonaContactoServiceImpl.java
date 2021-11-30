package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaContactoDAO;
import com.disenio.dto.persona.ContactosAltaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.services.personas.PersonaContactoService;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class PersonaContactoServiceImpl implements PersonaContactoService {

    @Autowired
    SeteosVariosUtilServiceImpl seteosVariosUtilService;
    @Autowired
    private PersonaContactoDAO personaContactoDAO;
    @Autowired
    private PersonaService personaService;

    @Transactional
    @Override
    public void alta(List<ContactosAltaDTO> listPersonaContactosDTO, Persona persona) throws ParseException {

        List<PersonaContacto> personaContactos = seteosVariosUtilService.setContactosAlta(listPersonaContactosDTO, persona);
        persona.setPersonaContactos(personaContactos);
        personaService.alta(persona);

    }
}
