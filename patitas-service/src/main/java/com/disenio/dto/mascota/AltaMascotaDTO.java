package com.disenio.dto.mascota;

import lombok.Data;

import java.util.List;

@Data
public class AltaMascotaDTO {
    private Integer idMascota;
    private String nombre;
    private String apodo;
    private String fechaNacimiento;
    private Integer idSexo;
    private String descripcionFisica;
    private Integer idTipoMascota;
    private Integer idPersona;
    private String valorFoto;
    private String url;
    private String respuesta;
    private List<AltaCaracteristicasMascotaDTO> caracteristicas;

}
