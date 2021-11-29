package com.disenio.dto.mascota;

import com.disenio.model.faq.Faq;
import com.disenio.model.mascotas.CaracteristicaDetalleValor;
import com.disenio.model.mascotas.Mascota;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class CaracteristicaDetalleDTO {

    private Integer idDetalle;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Faq faq;
    private char estado;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<CaracteristicaDetalleValorDTO> caracteristicaDetalleValors;
}
