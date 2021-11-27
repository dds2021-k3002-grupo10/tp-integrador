package com.disenio.dao.faq;

import com.disenio.model.faq.FaqRespuestaValor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRespuestaValorDAO extends JpaRepository<FaqRespuestaValor,Integer> {
}
