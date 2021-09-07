package com.disenio.services.caracteristicas;

import com.disenio.model.caracteristicas.Caracteristica;

import java.util.List;

public interface CaracteristicaService {

    void alta(Caracteristica caracteristica);

    List<Caracteristica> getCaracteristicaAll();

    List<Caracteristica> getCaracteristicaByOrganizacionId(Integer idOrganizacion);
}
