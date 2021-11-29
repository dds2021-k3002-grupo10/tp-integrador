package com.disenio.dto.mascota;


import com.disenio.dto.persona.DTOPersona;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DTOMascota implements Serializable {

    Integer idMascota;
    DTOPersona duenio;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    SexoMascota sexo;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    TipoMascota tipoMascota;
    String foto;
    String nombre;
    String apodo;
    String descripcionFisica;
    List<DTOMascotaCaracteristica> caracteristicas;

    //Constructors
    public DTOMascota(Integer idMascota, DTOPersona duenio, SexoMascota sexo, TipoMascota tipoMascota, String nombre, String apodo, String descripcionFisica, List<DTOMascotaCaracteristica> caracteristicas) {
        this.idMascota = idMascota;
        this.duenio = duenio;
        this.sexo = sexo;
        this.tipoMascota = tipoMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.descripcionFisica = descripcionFisica;
        this.caracteristicas = caracteristicas;
    }

    public DTOMascota(Mascota mascota) {
        this.idMascota = mascota.getIdMascota();
        this.duenio = new DTOPersona(mascota.getPersona());
        this.sexo = mascota.getSexoMascota();
        this.tipoMascota = mascota.getTipoMascota();
        this.nombre = mascota.getNombre();
        this.apodo = mascota.getApodo();
        this.descripcionFisica = mascota.getDescripcionFisica();
        this.caracteristicas = mascota.getCaracteristicaDetalles().stream().map(DTOMascotaCaracteristica::new).collect(Collectors.toList());
        this.foto = mascota.getMascotaFotos().stream().findFirst().get().getValorFoto();
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<DTOMascotaCaracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<DTOMascotaCaracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
