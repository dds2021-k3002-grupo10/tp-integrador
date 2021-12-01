package com.disenio.dto.mascota;

import com.disenio.model.faq.Faq;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class CaracteristicaDetalleDTO {

    private Integer idDetalle;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Faq faq;
    private char estado;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<CaracteristicaDetalleValorDTO> caracteristicaDetalleValors;
}
