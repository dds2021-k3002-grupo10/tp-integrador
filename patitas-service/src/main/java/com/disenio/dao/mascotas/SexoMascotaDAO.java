package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.SexoMascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexoMascotaDAO extends JpaRepository<SexoMascota,Integer> {
}
