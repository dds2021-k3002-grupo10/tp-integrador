package com.disenio.dto.faq;

import lombok.Data;

import java.util.List;

@Data
public class FaqALtaDTO {
    private Integer idFaq;
    private Integer idComportamientoTipo;
    private Integer idPreguntaTipo;
    private String descripcionFaq;
    private Integer idOrganizacion;
    private Integer idUsuario;
    private String estado;
    private List<FaqRespuestaValorDTO> faqRespuestaValors;

}
