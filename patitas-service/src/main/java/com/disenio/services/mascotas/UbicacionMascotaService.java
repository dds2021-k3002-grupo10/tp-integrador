package com.disenio.services.mascotas;

import com.disenio.model.mascotas.UbicacionMascotaRescatada;

import java.util.List;
import java.util.Optional;

public interface UbicacionMascotaService {

    List<UbicacionMascotaRescatada> getAllTipoMascota();
    Optional<UbicacionMascotaRescatada> getById(Integer id);
    void alta(UbicacionMascotaRescatada u);
}
