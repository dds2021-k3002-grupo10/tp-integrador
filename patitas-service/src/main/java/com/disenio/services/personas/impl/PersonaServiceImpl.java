package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaDAO;
import com.disenio.model.personas.Persona;
import com.disenio.services.mascotas.MascotasService;
import com.disenio.services.personas.PersonaContactoService;
import com.disenio.services.personas.PersonaDireccionService;
import com.disenio.services.personas.PersonaDocumentoService;
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
    @Autowired
    private PersonaDocumentoService personaDocumentoService;
    @Autowired
    PersonaDireccionService personaDireccionService;
    @Autowired
    PersonaContactoService personaContactoService;
    @Autowired
    MascotasService mascotasService;

    @Transactional
    @Override
    public Persona alta(Persona persona) {
        //AltaPersona
        Persona rtaPersona= personaDAO.save(persona);

        //AltaPersonaDocumento
        personaDocumentoService.alta(persona.getPersonaDocumentos(), rtaPersona);

        //AltaPersonaDireccion
        personaDireccionService.alta(persona.getPersonaDireccions(),rtaPersona);

        //AltaPersonaContacto
        personaContactoService.alta(persona.getPersonaContactos(),rtaPersona);

        //AltaMascota
        mascotasService.alta(persona.getMascotas(),rtaPersona);


        return rtaPersona;

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
