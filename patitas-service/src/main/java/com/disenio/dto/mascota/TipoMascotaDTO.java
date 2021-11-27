package com.disenio.dto.mascota;

import lombok.Data;

import javax.persistence.Column;
@Data
public class TipoMascotaDTO {
    private Integer idTipoMascota;
    private String nombre;
}
