package com.disenio.dto.mascota;

import com.disenio.dto.persona.PersonaDTO;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class MascotaDTO {
    private Integer idMascota;
    private PersonaDTO persona;
    private SexoMascotaDTO sexoMascota;
    private TipoMascotaDTO tipoMascota;
    private String nombre;
    private String apodo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaNacimiento;
    private String descripcionFisica;
    private char estado;
    private List<CaracteristicaDetalleDTO> caracteristicaDetalles;
    private List<MascotaFotoDTO> mascotaFotos;

}
