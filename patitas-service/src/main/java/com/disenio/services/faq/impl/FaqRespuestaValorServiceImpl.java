package com.disenio.services.faq.impl;

import com.disenio.dao.faq.FaqRespuestaValorDAO;
import com.disenio.model.faq.FaqRespuestaValor;
import com.disenio.services.faq.FaqRespuestaValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqRespuestaValorServiceImpl implements FaqRespuestaValorService {

    @Autowired
    FaqRespuestaValorDAO faqRespuestaValorDAO;

    @Override
    public FaqRespuestaValor alta(FaqRespuestaValor faqRespuestaValor) {
        //despues de dar da alta en FAQ, da de alta las posibles respuestas
        FaqRespuestaValor rtaFaqRespuestaValor = faqRespuestaValorDAO.save(faqRespuestaValor);

        return rtaFaqRespuestaValor;
    }
}
