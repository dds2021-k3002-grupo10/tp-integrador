package com.disenio.dto.mascota;

import com.disenio.dto.faq.FaqRespuestaValorDTO;
import lombok.Data;


@Data
public class CaracteristicaDetalleValorDTO {
    private Integer idDetalleValor;
    private FaqRespuestaValorDTO faqRespuestaValor;
    private char estado;

}
