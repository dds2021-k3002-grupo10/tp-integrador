package com.disenio.services.personas;

import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDocumento;

import java.util.List;

public interface PersonaDocumentoService {

    void alta(List<PersonaDocumento> personaDocumentos, Persona persona);
}
