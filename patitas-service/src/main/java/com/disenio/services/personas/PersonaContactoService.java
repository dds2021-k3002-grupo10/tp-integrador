package com.disenio.services.personas;

import com.disenio.dto.persona.ContactosAltaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;

import java.util.List;

public interface PersonaContactoService {

    void alta(List<ContactosAltaDTO> personaContactos, Persona persona);

}
