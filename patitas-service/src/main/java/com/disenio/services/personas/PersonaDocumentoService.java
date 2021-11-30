package com.disenio.services.personas;

import com.disenio.dto.persona.DocumentoAltaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDocumento;

import java.util.List;
import java.util.Optional;

public interface PersonaDocumentoService {

    void alta(List<DocumentoAltaDTO> personaDocumentos, Persona persona);
}
