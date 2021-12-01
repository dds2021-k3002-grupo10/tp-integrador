package com.disenio.dto.mascota;

import lombok.Data;

import java.util.List;

@Data
public class CaracteristicaDetalleResumidoDTO {
    private Integer idDetalle;
    private Integer idFaq;
    private String descripcionFaq;
    private List<CaracteristicaDetalleValorResumidoDTO> cracteristicaDetalleValorResumidoDTO;
}
