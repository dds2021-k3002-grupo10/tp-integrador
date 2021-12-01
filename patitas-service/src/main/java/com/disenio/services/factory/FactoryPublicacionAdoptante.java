package com.disenio.services.factory;

import com.disenio.dto.publicacion.DTOPersonaPublicacion;
import com.disenio.dto.publicacion.DTOPublicacionAdoptante;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryPublicacionAdoptante implements Factory<PublicacionAdoptante, DTOPublicacionAdoptante> {
    @Autowired
    private PersonaService personaService;

    @Override
    public PublicacionAdoptante createFromDTO(DTOPublicacionAdoptante dtoPublicacion) {
        DTOPersonaPublicacion dtoPersona = dtoPublicacion.getAutor();

        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);

        return new PublicacionAdoptante(persona, dtoPublicacion.getDescripcion());
    }
}
