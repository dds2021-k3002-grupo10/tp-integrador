package com.disenio.services.organizacion;

import com.disenio.model.organizacion.Organizacion;

import java.util.Optional;

public interface OrganizacionService {

    Optional<Organizacion> getOrganizacionById(Integer id);
}
