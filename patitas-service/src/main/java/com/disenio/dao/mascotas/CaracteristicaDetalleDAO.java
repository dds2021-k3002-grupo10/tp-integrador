package com.disenio.dao.mascotas;

import com.disenio.model.caracteristicas.CaracteristicaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaDetalleDAO extends JpaRepository<CaracteristicaDetalle, Integer> {
}
