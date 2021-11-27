package com.disenio.services.faq.impl;

import com.disenio.dao.faq.FaqComportamientoTipoDAO;
import com.disenio.model.faq.FaqComportamientoTipo;
import com.disenio.services.faq.FaqComportamientoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaqComportamientoTipoServiceImpl implements FaqComportamientoTipoService {
    @Autowired
    FaqComportamientoTipoDAO faqComportamientoTipoDAO;
    @Override
    public List<FaqComportamientoTipo> getFaqComportamientoTipoAll() {
        return faqComportamientoTipoDAO.findAll(Sort.by(Sort.Direction.ASC, "idComportamientoTipo"));
    }

    @Override
    public Optional<FaqComportamientoTipo> getFaqComportamientoTipoById(Integer id) {
        return faqComportamientoTipoDAO.findById(id);
    }
}
