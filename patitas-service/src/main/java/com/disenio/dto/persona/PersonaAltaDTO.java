package com.disenio.dto.persona;

import lombok.Data;

import java.util.List;

@Data
public class PersonaAltaDTO {
    List<ContactosAltaDTO> contactos;
    private Integer idPersona;
    private String respuesta;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private DocumentoAltaDTO documento;
    private Integer idNotificacion;
}
