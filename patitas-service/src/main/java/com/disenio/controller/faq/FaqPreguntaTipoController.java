package com.disenio.controller.faq;

import com.disenio.model.faq.FaqPreguntaTipo;
import com.disenio.services.faq.FaqPreguntaTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/preguntas-tipo")
public class FaqPreguntaTipoController {
    @Autowired
    private FaqPreguntaTipoService faqPreguntaTipoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<FaqPreguntaTipo>> getFaqFaqPreguntaTipoAll() {
        ResponseEntity<List<FaqPreguntaTipo>> response;

        List<FaqPreguntaTipo> fqPreguntaTipo = faqPreguntaTipoService.getFaqPreguntaTipoAll();
        if (fqPreguntaTipo.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(fqPreguntaTipo);
        }
        return response;

    }
}
