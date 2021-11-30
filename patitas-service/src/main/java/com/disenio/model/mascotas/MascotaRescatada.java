package com.disenio.model.mascotas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * MascotaRescatada generated by Grupo 10
 */
@Entity
@Table(name = "mascota_rescatada", catalog = "patitas"
)
public class MascotaRescatada implements java.io.Serializable {


    private Integer idMascotaRescatada;
    private Persona persona;
    private TamanioMascota tamanioMascota;
    private TipoMascota tipoMascota;
    private String descripcion;
    private Date fechaAlta;
    private Date fechaUltimaModificacion;
    private Date fechaBaja;
    private char estado;
    private UbicacionMascotaRescatada ubicacionMascotaRescatadas;
    private List<MascotaFoto> mascotaFotos = new ArrayList<>();

    //Constructors
    public MascotaRescatada() {
    }

    public MascotaRescatada(Persona persona, TamanioMascota tamanioMascota, TipoMascota tipoMascota, String descripcion) {
        this.persona = persona;
        this.tamanioMascota = tamanioMascota;
        this.tipoMascota = tipoMascota;
        this.descripcion = descripcion;
        this.fechaAlta = java.sql.Date.valueOf(LocalDate.now());
        this.fechaUltimaModificacion = java.sql.Date.valueOf(LocalDate.now());
        this.estado = 'A';
    }

    public MascotaRescatada(Integer idMascotaRescatada, Persona persona, TamanioMascota tamanioMascota, TipoMascota tipoMascota, String descripcion, Date fechaAlta, Date fechaUltimaModificacion, Date fechaBaja, char estado, UbicacionMascotaRescatada ubicacionMascotaRescatadas, List<MascotaFoto> mascotaFotos) {
        this.idMascotaRescatada = idMascotaRescatada;
        this.persona = persona;
        this.tamanioMascota = tamanioMascota;
        this.tipoMascota = tipoMascota;
        this.descripcion = descripcion;
        this.fechaAlta = fechaAlta;
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.fechaBaja = fechaBaja;
        this.estado = estado;
        this.ubicacionMascotaRescatadas = ubicacionMascotaRescatadas;
        this.mascotaFotos = new ArrayList<>();
    }


    //Getters and setters
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_MASCOTA_RESCATADA", unique = true, nullable = false)
    public Integer getIdMascotaRescatada() {
        return this.idMascotaRescatada;
    }

    public void setIdMascotaRescatada(Integer idMascotaRescatada) {
        this.idMascotaRescatada = idMascotaRescatada;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TAMANIO", nullable = false)
    public TamanioMascota getTamanioMascota() {
        return this.tamanioMascota;
    }

    public void setTamanioMascota(TamanioMascota tamanioMascota) {
        this.tamanioMascota = tamanioMascota;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPO_MASCOTA", nullable = false)
    public TipoMascota getTipoMascota() {
        return this.tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }


    @Column(name = "DESCRIPCION", nullable = false, length = 2000)
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    public Date getFechaUltimaModificacion() {
        return this.fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BAJA", length = 0)
    public Date getFechaBaja() {
        return this.fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }


    @Column(name = "ESTADO", nullable = false, length = 1)
    public char getEstado() {
        return this.estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_UBICACION", nullable = false)
     public UbicacionMascotaRescatada getUbicacionMascotaRescatadas() {
        return this.ubicacionMascotaRescatadas;
    }

    public void setUbicacionMascotaRescatadas(UbicacionMascotaRescatada ubicacionMascotaRescatadas) {
        this.ubicacionMascotaRescatadas = ubicacionMascotaRescatadas;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    public List<MascotaFoto> getMascotaFotos() {
        return this.mascotaFotos;
    }

    public void setMascotaFotos(List<MascotaFoto> mascotaFotos) {
        this.mascotaFotos = mascotaFotos;
    }


}


