package com.disenio.services.factory;

import com.disenio.dto.publicacion.DTOPersonaPublicacion;
import com.disenio.dto.publicacion.DTOPublicacionAdoptante;
import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.services.cuestionarios.CuestionarioService;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryPublicacionAdoptante implements Factory<PublicacionAdoptante, DTOPublicacionAdoptante> {
    @Autowired
    private PersonaService personaService;
    @Autowired
    private CuestionarioService cuestionarioService;


    @Override
    public PublicacionAdoptante createFromDTO(DTOPublicacionAdoptante dtoPublicacion) {
        DTOPersonaPublicacion dtoPersona = dtoPublicacion.getAutor();
        Integer idCuestionario = dtoPublicacion.getCuestionario().getIdCuestionario();
        Cuestionario cuestionario = cuestionarioService.getById(idCuestionario);
        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);
        PublicacionAdoptante publicacion = new PublicacionAdoptante();

        publicacion.setAutor(persona);
        publicacion.setDescripcion(dtoPublicacion.getDescripcion());
        publicacion.setCuestionario(cuestionario);


        return publicacion;
    }
}
