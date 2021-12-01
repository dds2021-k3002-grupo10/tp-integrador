package com.disenio.services.mascotas;

import com.disenio.dto.mascota.AltaMascotaDTO;
import com.disenio.dto.mascota.MascotaDTO;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;

import java.util.List;
import java.util.Optional;

public interface MascotasService {

    Optional<Mascota> getById(int id);

    AltaMascotaDTO alta(AltaMascotaDTO altaMascotaDTO);

    List<MascotaDTO> getMascotasAll();

    MascotaDTO getMascotaDTOById(Integer id);

    List<MascotaDTO> getMascotaByPersonasId(Integer id);


    List<Mascota> getAllMascotasByIdPersona(Integer idPersona);
}
