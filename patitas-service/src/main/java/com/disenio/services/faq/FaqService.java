package com.disenio.services.faq;

import com.disenio.dto.faq.FaqDTO;
import com.disenio.model.faq.Faq;

import java.util.List;
import java.util.Optional;

public interface FaqService {

    //void alta(Faq faq);

    //List<Faq> getFaqAll();

    Optional<Faq> getFaqByID(Integer id);

    List<FaqDTO> getFaqAllByOrganizacionAndPreguntaTipo(Integer idOrganizacion, Integer idPreguntaTipo);
}
