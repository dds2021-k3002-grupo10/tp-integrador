package com.disenio.dao.persona;

import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaContactoDAO extends JpaRepository<PersonaContacto,Integer> {
}
