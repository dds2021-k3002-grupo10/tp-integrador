package com.disenio.dto.persona;

import lombok.Data;


@Data
public class PersonaDocumentoDTO {
    private Integer idDocumento;
    private TipoDocumentoDTO tipoDocumento;
    private int numero;
}
