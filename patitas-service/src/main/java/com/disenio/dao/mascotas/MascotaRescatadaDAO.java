package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.MascotaRescatada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRescatadaDAO extends JpaRepository<MascotaRescatada, Integer> {
}
