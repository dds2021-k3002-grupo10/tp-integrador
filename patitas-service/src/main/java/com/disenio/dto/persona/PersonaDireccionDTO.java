package com.disenio.dto.persona;

import lombok.Data;

@Data
public class PersonaDireccionDTO {
    private Integer idDireccion;
    private String calle;
    private int numero;
    private Integer piso;
    private String departamento;
    private String observaciones;
    private Integer codPostal;
}
