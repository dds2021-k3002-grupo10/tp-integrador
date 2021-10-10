package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaDireccionDAO;
import com.disenio.dao.persona.PersonaDocumentoDAO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDocumento;
import com.disenio.services.personas.PersonaDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaDocumentoServiceImpl implements PersonaDocumentoService {
    @Autowired
    private PersonaDocumentoDAO personaDocumentoDAO;

    @Transactional
    @Override
    public void alta(List<PersonaDocumento> personaDocumentos, Persona persona) {
        personaDocumentos.forEach(personaDocumento -> {

            personaDocumento.setPersona(persona);
            //AltaPersonasContacto
            personaDocumentoDAO.save(personaDocumento);

        });
    }
}
