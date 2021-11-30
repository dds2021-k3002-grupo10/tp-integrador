package com.disenio.dto.persona;

import lombok.Data;

import java.util.List;

@Data
public class PersonaAltaDTO {
    private Integer idPersona;
    private String respuesta;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    List<DocumentoAltaDTO> documento;
    List<ContactosAltaDTO> contactos;
}
