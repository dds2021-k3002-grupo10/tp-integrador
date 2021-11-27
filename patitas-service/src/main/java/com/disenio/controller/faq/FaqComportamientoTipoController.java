package com.disenio.controller.faq;

import com.disenio.model.faq.FaqComportamientoTipo;
import com.disenio.services.faq.FaqComportamientoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comportamiento-tipo")
public class FaqComportamientoTipoController {

    @Autowired
    private FaqComportamientoTipoService faqComportamientoTipoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<FaqComportamientoTipo>> getFaqComportamientoTipoAll() {
        ResponseEntity<List<FaqComportamientoTipo>> response;

        List<FaqComportamientoTipo> faqComportamientoTipo = faqComportamientoTipoService.getFaqComportamientoTipoAll();
        if (faqComportamientoTipo.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(faqComportamientoTipo);
        }
        return response;

    }
}
