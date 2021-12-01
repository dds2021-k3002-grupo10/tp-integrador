package com.disenio.dto.publicacion;

import com.disenio.dto.mascota.DTOMascotaCaracteristica;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

public class DTOMascotaPublicacion {
    Integer idMascota;
    DTOPersonaPublicacion duenio;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    SexoMascota sexo;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    TipoMascota tipoMascota;
    List<String> foto;
    Integer edad;
    String nombre;
    String apodo;
    String descripcionFisica;
    List<DTOMascotaCaracteristica> caracteristicas;

    public DTOMascotaPublicacion(Integer idMascota, DTOPersonaPublicacion duenio, SexoMascota sexo, TipoMascota tipoMascota, List<String> foto, String nombre, String apodo, String descripcionFisica, List<DTOMascotaCaracteristica> caracteristicas) {
        this.idMascota = idMascota;
        this.duenio = duenio;
        this.sexo = sexo;
        this.tipoMascota = tipoMascota;
        this.foto = foto;
        this.nombre = nombre;
        this.apodo = apodo;
        this.descripcionFisica = descripcionFisica;
        this.caracteristicas = caracteristicas;
    }

    public DTOMascotaPublicacion(Mascota mascota) {
        this.idMascota = mascota.getIdMascota();
        this.duenio = new DTOPersonaPublicacion(mascota.getPersona());
        this.sexo = mascota.getSexoMascota();
        this.tipoMascota = mascota.getTipoMascota();
        this.nombre = mascota.getNombre();
        this.apodo = mascota.getApodo();
        this.descripcionFisica = mascota.getDescripcionFisica();
        this.caracteristicas = mascota.getCaracteristicaDetalles().stream().map(DTOMascotaCaracteristica::new).collect(Collectors.toList());
        this.foto = mascota.getMascotaFotos().stream().map(MascotaFoto::getValorFoto).collect(Collectors.toList());
        this.edad = mascota.getEdad();

    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public DTOPersonaPublicacion getDuenio() {
        return duenio;
    }

    public void setDuenio(DTOPersonaPublicacion duenio) {
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

    public List<String> getFoto() {
        return foto;
    }

    public void setFoto(List<String> foto) {
        this.foto = foto;
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

    public List<DTOMascotaCaracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<DTOMascotaCaracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
