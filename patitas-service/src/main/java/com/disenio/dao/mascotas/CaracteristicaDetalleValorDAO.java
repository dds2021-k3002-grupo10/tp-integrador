package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.CaracteristicaDetalleValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaDetalleValorDAO extends JpaRepository<CaracteristicaDetalleValor, Integer> {
}
