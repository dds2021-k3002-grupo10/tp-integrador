package com.disenio.services.personas;

import com.disenio.dto.persona.ContactosAltaDTO;
import com.disenio.model.personas.Persona;

import java.text.ParseException;
import java.util.List;

public interface PersonaContactoService {

    void alta(List<ContactosAltaDTO> personaContactos, Persona persona) throws ParseException;

    //void alta(ContactosAltaDTO personaContactos);

}
