package com.disenio.services.faq.impl;

import com.disenio.dao.faq.FaqDAO;
import com.disenio.dto.faq.FaqALtaDTO;
import com.disenio.dto.faq.FaqDTO;
import com.disenio.dto.faq.FaqRespuestaValorDTO;
import com.disenio.model.faq.Faq;
import com.disenio.model.faq.FaqComportamientoTipo;
import com.disenio.model.faq.FaqPreguntaTipo;
import com.disenio.model.faq.FaqRespuestaValor;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.faq.FaqComportamientoTipoService;
import com.disenio.services.faq.FaqPreguntaTipoService;
import com.disenio.services.faq.FaqRespuestaValorService;
import com.disenio.services.faq.FaqService;
import com.disenio.services.organizacion.OrganizacionService;
import com.disenio.services.usuarios.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class FaqServiceImpl implements FaqService {


    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    FaqRespuestaValorService faqRespuestaValorService;
    @Autowired
    FaqPreguntaTipoService faqPreguntaTipoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    FaqComportamientoTipoService faqComportamientoTipoService;
    @Autowired
    OrganizacionService organizacionService;
    @Autowired
    private FaqDAO faqDAO;

    @Transactional
    @Override
    public void alta(FaqALtaDTO faqAltaDTO) {
        Date date = new Date();
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        /*Settings*/
        Optional<FaqComportamientoTipo> comportamientoTipo = faqComportamientoTipoService.getFaqComportamientoTipoById(faqAltaDTO.getIdComportamientoTipo());
        FaqPreguntaTipo faqPreguntaTipo = faqPreguntaTipoService.getById(faqAltaDTO.getIdPreguntaTipo());
        Organizacion organizacion = organizacionService.getOrganizacionById(faqAltaDTO.getIdOrganizacion());
        Usuario usuario = usuarioService.getById(faqAltaDTO.getIdUsuario());

        /*Seting  FAQ*/
        Faq faq = new Faq();
        faq.setDescripcionFaq(faqAltaDTO.getDescripcionFaq().toUpperCase());
        faq.setFaqComportamientoTipo(comportamientoTipo.get());
        faq.setFaqPreguntaTipo(faqPreguntaTipo);
        faq.setOrganizacion(organizacion);
        faq.setEstado("A");
        //faq.setUsuario(usuario);
        faq.setFechaAlta(date);
        faq.setFechaUltimaModificacion(date);

        //Alta a FAQ
        Faq rtaFaq = faqDAO.save(faq);

        if (rtaFaq != null) {

            for (FaqRespuestaValorDTO faqRespuestaValorDTO : faqAltaDTO.getFaqRespuestaValors()) {

                //seteo RespuestaVAlor
                FaqRespuestaValor faqRespuestaValor = new FaqRespuestaValor();
                //faqRespuestaValor.setFaq(rtaFaq);
                faq.addFaqRespuesta(faqRespuestaValor);
                faqRespuestaValor.setDescripcion(faqRespuestaValorDTO.getDescripcion().toUpperCase());

                //Alta a los valores de respuestas de cada pregunta
                FaqRespuestaValor rdoRespuestaValor = faqRespuestaValorService.alta(faqRespuestaValor);

            }
        }
    }

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
