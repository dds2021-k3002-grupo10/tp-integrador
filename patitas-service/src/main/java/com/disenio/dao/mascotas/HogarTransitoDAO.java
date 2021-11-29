package com.disenio.dao.mascotas;

import com.disenio.model.mascotas.MascotaHogarTransito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HogarTransitoDAO extends JpaRepository<MascotaHogarTransito, Integer> {
}
