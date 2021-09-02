package com.disenio.dao;

import com.disenio.entities.caracteristicas.Caracteristica;
import com.disenio.entities.caracteristicas.ComportamientoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CaracteristicaDAO")
public interface CaracteristicaDAO extends JpaRepository<Caracteristica,Integer> {
}
