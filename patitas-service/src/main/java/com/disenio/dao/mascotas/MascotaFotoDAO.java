package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.MascotaFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaFotoDAO extends JpaRepository<MascotaFoto, Integer> {
}
