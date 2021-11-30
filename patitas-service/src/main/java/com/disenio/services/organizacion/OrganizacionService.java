package com.disenio.services.organizacion;

import com.disenio.dto.organizacion.OrganizacionDTO;
import com.disenio.model.organizacion.Organizacion;

import java.util.List;
import java.util.Optional;

public interface OrganizacionService {
    void alta(Organizacion organizacion);
   Organizacion getOrganizacionById(Integer id);

   List<OrganizacionDTO> getOrganizacionAll();
}
