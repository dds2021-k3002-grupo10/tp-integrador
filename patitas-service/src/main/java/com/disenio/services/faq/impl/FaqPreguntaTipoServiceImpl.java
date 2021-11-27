package com.disenio.services.faq.impl;

import com.disenio.dao.faq.FaqPreguntaTipoDAO;
import com.disenio.model.faq.FaqPreguntaTipo;
import com.disenio.services.faq.FaqPreguntaTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqPreguntaTipoServiceImpl implements FaqPreguntaTipoService {
    @Autowired
    FaqPreguntaTipoDAO faqPreguntaTipoDAO;

    @Override
    public FaqPreguntaTipo getById(Integer idPReguntaTipo) {
        return faqPreguntaTipoDAO.getById(idPReguntaTipo);
    }

    @Override
    public List<FaqPreguntaTipo> getFaqPreguntaTipoAll() {
        return faqPreguntaTipoDAO.findAll(Sort.by(Sort.Direction.ASC, "idPreguntaTipo"));
    }
}
