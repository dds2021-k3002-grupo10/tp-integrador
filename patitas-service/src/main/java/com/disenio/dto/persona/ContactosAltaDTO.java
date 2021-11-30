package com.disenio.dto.persona;

import lombok.Data;

@Data
public class ContactosAltaDTO {
    private String nombreContacto;
    private String apellidoContacto;
    private String telefonoContacto;
    private String emailContacto;
    private Integer idNotificacion;
}
