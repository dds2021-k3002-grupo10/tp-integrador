package com.disenio.services.mascotas;

import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaFoto;

import java.util.List;

public interface MascotaFotoService {

    void alta(String valorFoto, Mascota mascota);

    void alta(List<MascotaFoto> mascotaFotos, Mascota mascota);
}
