package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.UbicacionMascotaRescatada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionMascotaDAO extends JpaRepository<UbicacionMascotaRescatada, Integer> {
}
