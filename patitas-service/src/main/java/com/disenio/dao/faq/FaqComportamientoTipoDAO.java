package com.disenio.dao.faq;

import com.disenio.model.faq.FaqComportamientoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqComportamientoTipoDAO extends JpaRepository<FaqComportamientoTipo, Integer> {
}
