package com.disenio.services.faq.impl;

import com.disenio.dao.faq.FaqDAO;
import com.disenio.dto.faq.FaqDTO;
import com.disenio.model.faq.Faq;
import com.disenio.services.faq.FaqPreguntaTipoService;
import com.disenio.services.faq.FaqRespuestaValorService;
import com.disenio.services.faq.FaqService;
import com.disenio.services.usuarios.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService {


    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FaqDAO faqDAO;

    @Autowired
    FaqRespuestaValorService faqRespuestaValorService;
    @Autowired
    FaqPreguntaTipoService faqPreguntaTipoService;
    @Autowired
    UsuarioService usuarioService;

    /*@Transactional
    @Override
    public void alta(Faq faq) {
        Faq rtaFaq = new Faq();

        //seteo el tipo de pregunta dirigido a caracteristica o proguntas de adoptante o adoptador
        faq.setFaqPreguntaTipo(faqPreguntaTipoService.getById(faq.getFaqPreguntaTipo().getIdPreguntaTipo()));
        //seteo usuario quien esta dando de alta un nuevo FAQ
        faq.setUsuario(usuarioService.getById(faq.getUsuario().getIdUsuario()));

        //Alta a FAQ
        rtaFaq = faqDAO.save(faq);

        for (FaqRespuestaValor faqRespuestaValor : faq.getFaqRespuestaValors()) {

            //Alta a los valores de respuestas de cada pregunta
            faqRespuestaValor.setFaq(rtaFaq);
            FaqRespuestaValor rdoRespuestaValor = faqRespuestaValorService.alta(faqRespuestaValor);

        }
    }*/

    @Override
    public Optional<Faq> getFaqByID(Integer id) {
        return faqDAO.findById(id);
    }

    @Override
    public List<FaqDTO> getFaqAllByOrganizacionAndPreguntaTipo(Integer idOrganizacion, Integer idPreguntaTipo) {
        List<Faq> faq = faqDAO.findByOrganizacionAndPreguntaTipo(idOrganizacion, idPreguntaTipo);
        List<FaqDTO> faqDTO = new ArrayList<FaqDTO>();
        if (!faq.isEmpty()) {
            faqDTO = Arrays.asList(modelMapper.map(faq, FaqDTO[].class));
        }
        return faqDTO;
    }
}
