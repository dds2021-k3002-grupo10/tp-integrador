package com.disenio.services.mascotas;

import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.model.personas.Persona;

import java.util.List;

public interface MascotaFotoService {

    void alta(List<MascotaFoto> mascotaFoto, Mascota mascota);
}
