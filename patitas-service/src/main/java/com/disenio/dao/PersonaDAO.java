package com.disenio.dao;

import com.disenio.models.personas.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PersonaDAO")
public interface PersonaDAO extends JpaRepository<Persona,Long> {
}
