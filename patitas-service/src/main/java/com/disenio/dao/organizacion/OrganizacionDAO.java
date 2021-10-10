package com.disenio.dao.organizacion;

import com.disenio.model.organizacion.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacionDAO extends JpaRepository<Organizacion, Integer> {
}
