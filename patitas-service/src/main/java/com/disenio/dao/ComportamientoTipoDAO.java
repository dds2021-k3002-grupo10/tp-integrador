package com.disenio.dao;

import com.disenio.entities.caracteristicas.ComportamientoTipo;
import com.disenio.entities.personas.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ComportamientoTipoDAO")
public interface ComportamientoTipoDAO extends JpaRepository<ComportamientoTipo,Integer> {
}
