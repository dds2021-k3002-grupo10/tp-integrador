package com.disenio.services.personas;

import com.disenio.dto.persona.PersonaDTO;
import com.disenio.model.personas.Persona;

import java.util.List;
import java.util.Optional;


public interface PersonaService {

    Persona alta(Persona persona);

    List<PersonaDTO> getListaAllPersona();

    PersonaDTO getPersonaDTOById(Integer id);

    Optional<Persona> getPersonasById(Integer id);

    List<PersonaDTO> getPersonasByCondicion(Integer idTipoDoc,Integer numero);

}
