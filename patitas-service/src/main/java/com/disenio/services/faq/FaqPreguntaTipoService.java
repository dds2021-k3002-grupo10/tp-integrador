package com.disenio.services.faq;

import com.disenio.model.faq.FaqPreguntaTipo;

import java.util.List;

public interface FaqPreguntaTipoService {

    FaqPreguntaTipo getById(Integer idPReguntaTipo);

    List<FaqPreguntaTipo>  getFaqPreguntaTipoAll();
}
