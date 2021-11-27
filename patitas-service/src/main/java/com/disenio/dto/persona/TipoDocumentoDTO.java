package com.disenio.dto.persona;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class TipoDocumentoDTO {
    private Integer idTipoDoc;
    private String descripcionCorta;
    private String descripcionLarga;
}
