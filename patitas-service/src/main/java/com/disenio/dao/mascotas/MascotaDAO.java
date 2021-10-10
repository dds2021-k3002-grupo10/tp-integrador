package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaDAO extends JpaRepository<Mascota,Integer> {
}
