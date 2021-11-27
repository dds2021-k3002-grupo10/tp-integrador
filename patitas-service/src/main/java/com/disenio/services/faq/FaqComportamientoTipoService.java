package com.disenio.services.faq;


import com.disenio.model.faq.FaqComportamientoTipo;

import java.util.List;
import java.util.Optional;

public interface FaqComportamientoTipoService {

    List<FaqComportamientoTipo>  getFaqComportamientoTipoAll();

    Optional<FaqComportamientoTipo> getFaqComportamientoTipoById(Integer id);
}
