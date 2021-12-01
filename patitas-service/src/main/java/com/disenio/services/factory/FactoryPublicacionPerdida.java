package com.disenio.services.factory;

import com.disenio.dto.mascota.DTOMascotaPerdida;
import com.disenio.dto.mascota.DTOUbicacionMascota;
import com.disenio.dto.publicacion.DTOPersonaPublicacion;
import com.disenio.dto.publicacion.DTOPublicacionPerdida;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.mascotas.UbicacionMascotaRescatada;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.personas.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactoryPublicacionPerdida implements Factory<PublicacionPerdida, DTOPublicacionPerdida> {

    @Autowired
    private PersonaService personaService;

    public PublicacionPerdida createFromDTO(DTOPublicacionPerdida dtoPublicacion) {
        DTOPersonaPublicacion dtoPersona = dtoPublicacion.getAutor();
        DTOMascotaPerdida dtoMascota = dtoPublicacion.getMascota();
        DTOUbicacionMascota ubicacionDTO = dtoMascota.getUbicacion();

        UbicacionMascotaRescatada ubicacion = new UbicacionMascotaRescatada(ubicacionDTO.getDireccion(), ubicacionDTO.getLatitud(), ubicacionDTO.getLongitud());
        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);
        MascotaRescatada mascotaPerdida = new MascotaRescatada(persona, dtoMascota.getTamanioMascota(), dtoMascota.getTipoMascota(), dtoPublicacion.getDescripcion());

        //TODO: Cambiar para que sean muchas fotos
        List<MascotaFoto> mascotaFotos = dtoMascota.getFoto().stream().map(s -> new MascotaFoto(s)).collect(Collectors.toList());

        ubicacion.setIdHogar(dtoPublicacion.getIdHogar());
        mascotaPerdida.setUbicacionMascotaRescatadas(ubicacion);
        mascotaPerdida.setMascotaFotos(mascotaFotos);
        //TODO: Aca se hace la verificacion de si puede la mascota ir o no a ese hogar

        return new PublicacionPerdida(persona, mascotaPerdida);
    }
}
