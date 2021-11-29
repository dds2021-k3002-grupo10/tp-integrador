package com.disenio.dto.mascota;

import com.disenio.dto.faq.FaqRespuestaValorDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
public class CaracteristicaDetalleValorDTO {
    private Integer idDetalleValor;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FaqRespuestaValorDTO faqRespuestaValor;
    private char estado;

}
