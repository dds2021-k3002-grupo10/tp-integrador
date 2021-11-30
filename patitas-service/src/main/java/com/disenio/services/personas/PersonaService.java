package com.disenio.services.personas;

import com.disenio.dto.persona.PersonaAltaDTO;
import com.disenio.dto.persona.PersonaBusquedaByDocDTO;
import com.disenio.dto.persona.PersonaDTO;
import com.disenio.model.personas.Persona;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;


public interface PersonaService {

    Persona alta(PersonaAltaDTO personaAltaDTO) throws ParseException;

    List<PersonaDTO> getListaAllPersona();

    PersonaDTO getPersonaDTOById(Integer id);

    Optional<Persona> getPersonasById(Integer id);

    List<PersonaBusquedaByDocDTO> getPersonasByCondicion(Integer idTipoDoc, Integer numero);

}
