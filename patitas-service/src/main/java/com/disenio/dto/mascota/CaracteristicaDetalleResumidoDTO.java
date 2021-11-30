package com.disenio.dto.mascota;

import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.CaracteristicaDetalleValor;
import lombok.Data;

import java.util.List;

@Data
public class CaracteristicaDetalleResumidoDTO {
    private Integer idDetalleValor;
    private Integer idFaq;
    private String descripcionFaq;
    private List<CaracteristicaDetalleValorResumidoDTO> cracteristicaDetalleValorResumidoDTO;
}
