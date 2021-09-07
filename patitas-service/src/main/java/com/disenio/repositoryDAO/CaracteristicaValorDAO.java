package com.disenio.repositoryDAO;

import com.disenio.model.caracteristicas.CaracteristicaValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CaracteristicaValorDAO")
public interface CaracteristicaValorDAO extends JpaRepository<CaracteristicaValor,Integer> {
}
