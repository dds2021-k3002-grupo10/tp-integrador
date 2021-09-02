package com.disenio.dao;

import com.disenio.entities.caracteristicas.Caracteristica;
import com.disenio.entities.caracteristicas.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ValorDAO")
public interface ValorDAO extends JpaRepository<Valor,Integer> {
}
