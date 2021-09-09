package com.disenio.dao;

import com.disenio.model.caracteristicas.ComportamientoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ComportamientoTipoDAO")
public interface ComportamientoTipoDAO extends JpaRepository<ComportamientoTipo,Integer> {
}
