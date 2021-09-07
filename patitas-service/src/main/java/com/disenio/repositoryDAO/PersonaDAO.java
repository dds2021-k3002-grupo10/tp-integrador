package com.disenio.repositoryDAO;

import com.disenio.model.personas.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PersonaDAO")
public interface PersonaDAO extends JpaRepository<Persona,Integer> {
}
