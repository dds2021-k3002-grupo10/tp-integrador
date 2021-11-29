package com.disenio.dao.cuestionario;

import com.disenio.model.cuestionario.Cuestionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CuestionarioDAO")
public interface CuestionarioDAO extends JpaRepository<Cuestionario, Integer> {
}
