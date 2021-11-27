package com.disenio.dao.faq;

import com.disenio.model.faq.FaqPreguntaTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqPreguntaTipoDAO extends JpaRepository<FaqPreguntaTipo,Integer> {
}
