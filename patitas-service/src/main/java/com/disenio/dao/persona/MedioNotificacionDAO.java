package com.disenio.dao.persona;

import com.disenio.model.personas.MedioNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioNotificacionDAO extends JpaRepository<MedioNotificacion,Integer> {
}
