package com.disenio.dto.mascota;

import com.disenio.dto.persona.DTOPersona;
import com.disenio.model.Views;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;

@Data
public class DTOMascota implements Serializable {
    @JsonView(Views.External.class)
    Integer idMascota;
    @JsonView(Views.External.class)
    DTOPersona duenio;
    @JsonView(Views.External.class)
    SexoMascota sexo;
    @JsonView(Views.External.class)
    TipoMascota tipoMascota;
    @JsonView(Views.External.class)
    String nombre;
    @JsonView(Views.External.class)
    String apodo;
    @JsonView(Views.External.class)
    String descripcionFisica;
    //TODO CARACTERTISTICAS

    //Constructors

    public DTOMascota(Integer idMascota, DTOPersona duenio, SexoMascota sexo, TipoMascota tipoMascota, String nombre, String apodo, String descripcionFisica) {
        this.idMascota = idMascota;
        this.duenio = duenio;
        this.sexo = sexo;
        this.tipoMascota = tipoMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.descripcionFisica = descripcionFisica;
    }

    public DTOMascota(Mascota mascota) {
        this.idMascota = mascota.getIdMascota();
        this.duenio = new DTOPersona(mascota.getPersona());
        this.sexo = mascota.getSexoMascota();
        this.tipoMascota = mascota.getTipoMascota();
        this.nombre = mascota.getNombre();
        this.apodo = mascota.getApodo();
        this.descripcionFisica = mascota.getDescripcionFisica();
    }

    //Getters and Setters


    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public DTOPersona getDuenio() {
        return duenio;
    }

    public void setDuenio(DTOPersona duenio) {
        this.duenio = duenio;
    }

    public SexoMascota getSexo() {
        return sexo;
    }

    public void setSexo(SexoMascota sexo) {
        this.sexo = sexo;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }
}
