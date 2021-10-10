package com.disenio.dao.persona;

import com.disenio.model.personas.PersonaDireccion;
import jdk.Exported;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDireccionDAO extends JpaRepository<PersonaDireccion, Integer> {
}
