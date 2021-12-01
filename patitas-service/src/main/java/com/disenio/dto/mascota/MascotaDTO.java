package com.disenio.dto.mascota;

import com.disenio.dto.persona.PersonaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
public class MascotaDTO {
    private Integer idMascota;
    private PersonaDTO persona;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private SexoMascotaDTO sexoMascota;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoMascotaDTO tipoMascota;
    private String nombre;
    private String apodo;
    /*    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        @JsonDeserialize(using = DateDeserializers.CalendarDeserializer.class)
        private Calendar fechaNacimiento;
     */
    private String edad;
    private String descripcionFisica;
    private char estado;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<CaracteristicaDetalleDTO> caracteristicaDetalles;
    private List<CaracteristicaDetalleResumidoDTO> caracteristicaDetalleValorResumidoDTO;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<MascotaFotoDTO> mascotaFotos;

}
