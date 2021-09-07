package com.disenio.repositoryDAO;

import com.disenio.model.caracteristicas.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ValorDAO")
public interface ValorDAO extends JpaRepository<Valor,Integer> {
}
