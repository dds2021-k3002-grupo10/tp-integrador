package com.disenio.dto.mascota;

import com.disenio.dto.persona.PersonaDTO;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaNacimiento;
    private String descripcionFisica;
    private char estado;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<CaracteristicaDetalleDTO> caracteristicaDetalles;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<MascotaFotoDTO> mascotaFotos;

}
