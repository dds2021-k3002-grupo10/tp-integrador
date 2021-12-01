package com.disenio.services.factory;

import com.disenio.dto.publicacion.DTOMascotaPublicacion;
import com.disenio.dto.publicacion.DTOPersonaPublicacion;
import com.disenio.dto.publicacion.DTOPublicacionDarAdopcion;
import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.services.cuestionarios.CuestionarioService;
import com.disenio.services.mascotas.MascotasService;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryPublicacionDarAdopcion implements Factory<PublicacionDarAdopcion, DTOPublicacionDarAdopcion> {
    @Autowired
    PersonaService personaService;
    @Autowired
    MascotasService mascotasService;
    @Autowired
    private CuestionarioService cuestionarioService;

    @Override
    public PublicacionDarAdopcion createFromDTO(DTOPublicacionDarAdopcion dtoPublicacion) {
        DTOPersonaPublicacion dtoPersona = dtoPublicacion.getAutor();
        DTOMascotaPublicacion dtoMascota = dtoPublicacion.getMascota();
        Integer idCuestionario = dtoPublicacion.getCuestionario().getIdCuestionario();
        Cuestionario cuestionario = cuestionarioService.getById(idCuestionario);
        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);
        Mascota mascota = mascotasService.getById(dtoMascota.getIdMascota()).orElse(null);
        PublicacionDarAdopcion publicacionDarAdopcion = new PublicacionDarAdopcion(persona, mascota, dtoPublicacion.getDescripcion());

        publicacionDarAdopcion.setCuestionario(cuestionario);

        return publicacionDarAdopcion;
    }
}
