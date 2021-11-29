package com.disenio.model.mascotas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * generated by grupo10
 */
@Entity
@Data
@Table(name = "mascota", catalog = "patitas")
public class Mascota implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_MASCOTA", unique = true, nullable = false)
    private Integer idMascota;

    @Column(name = "EDAD", unique = true, nullable = false)
    private Integer edad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SEXO", nullable = false)
    private SexoMascota sexoMascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_MASCOTA", nullable = false)
    private TipoMascota tipoMascota;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "APODO", nullable = false, length = 50)
    private String apodo;

    @Column(name = "FECHA_NACIMIENTO", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT+8")
    private Calendar fechaNacimiento;

    @Column(name = "DESCRIPCION_FISICA", nullable = false, length = 2000)
    private String descripcionFisica;

    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaAlta;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaUltimaModificacion;

    @Column(name = "FECHA_BAJA", length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaBaja;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mascota")
    private List<CaracteristicaDetalle> caracteristicaDetalles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mascota")
    private List<MascotaFoto> mascotaFotos;


}


