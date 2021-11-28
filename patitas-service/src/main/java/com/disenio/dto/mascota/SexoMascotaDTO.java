package com.disenio.dto.mascota;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
@Data
public class SexoMascotaDTO {
    private Integer idSexo;
    private String descripcion;
}
