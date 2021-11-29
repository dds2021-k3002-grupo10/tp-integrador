package com.disenio.services.mascotas;

import com.disenio.model.mascotas.MascotaRescatada;

import java.util.Optional;

public interface MascotaRescatadaService {
    Optional<MascotaRescatada> getById(int id);

    void alta(MascotaRescatada mascotas);
}
