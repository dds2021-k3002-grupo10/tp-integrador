package com.disenio.dto.faq;

import lombok.Data;

import java.util.List;


@Data
public class FaqDTO {
    private Integer idFaq;
    private FaqComportamientoTipoDTO faqComportamientoTipo;
    private String descripcionFaq;
    private String estado;
    private List<FaqRespuestaValorDTO> faqRespuestaValors;
}
