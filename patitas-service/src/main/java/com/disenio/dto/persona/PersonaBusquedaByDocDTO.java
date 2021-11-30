package com.disenio.dto.persona;

import lombok.Data;

@Data
public class PersonaBusquedaByDocDTO {
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private int NroDoc;
    private int cantidadMascota;
    private char estado;
}
