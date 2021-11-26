package com.disenio.services.mascotas;

import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.TamanioMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.model.personas.Persona;

import java.util.List;
import java.util.Optional;

public interface TamanioMascotaService {
    Optional<TamanioMascota> getById(int id);
    List<TamanioMascota> getAllTamanioMascota();
}
