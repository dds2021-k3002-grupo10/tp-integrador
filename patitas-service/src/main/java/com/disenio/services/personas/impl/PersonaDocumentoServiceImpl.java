package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaDocumentoDAO;
import com.disenio.dto.persona.DocumentoAltaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDocumento;
import com.disenio.model.personas.TipoDocumento;
import com.disenio.services.personas.PersonaDocumentoService;
import com.disenio.services.personas.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaDocumentoServiceImpl implements PersonaDocumentoService {
    @Autowired
    private PersonaDocumentoDAO personaDocumentoDAO;
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @Autowired
    SeteosVariosUtilServiceImpl seteosVariosUtilService;

    @Transactional
    @Override
    public void alta(List<DocumentoAltaDTO> listDocumentoAltaDTOS, Persona persona) {


        List<PersonaDocumento> personaDocumentos = seteosVariosUtilService.setDocumentos(listDocumentoAltaDTOS);

        personaDocumentos.forEach(personaDocumento -> {

            personaDocumento.setPersona(persona);
            Integer idTipoDoc = personaDocumento.getTipoDocumento().getIdTipoDoc();
            Optional<TipoDocumento> tipoDocumento = tipoDocumentoService.getTipoDocuemntoById(idTipoDoc);

            personaDocumento.setTipoDocumento(tipoDocumento.get());
            //alta personaDocumento
            personaDocumentoDAO.save(personaDocumento);

        });
    }
}
