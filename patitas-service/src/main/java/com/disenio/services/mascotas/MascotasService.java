package com.disenio.services.mascotas;

import com.disenio.dto.mascota.MascotaDTO;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;

import java.util.List;

public interface MascotasService {

    void alta(List<Mascota> mascotas, Persona persona);

    List<MascotaDTO> getMascotasAll();

    MascotaDTO getMascotaDTOById(Integer id);

    MascotaDTO getMascotaByPersonasId(Integer id);

}
