package com.disenio.services.caracteristicas;

import com.disenio.model.caracteristicas.Caracteristica;

import java.util.List;
import java.util.Optional;

public interface CaracteristicaService {

    void alta(Caracteristica caracteristica);

    List<Caracteristica> getCaracteristicaAll();

    Optional<Caracteristica> getCaracteristicaByID(Integer id);

    List<Caracteristica> getCaracteristicaByOrganizacionId(Integer idOrganizacion);
}
