package com.disenio.dto.mascota;

import com.disenio.dto.publicacion.DTOPersonaPublicacion;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.mascotas.TamanioMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DTOMascotaPerdida implements Serializable {
    Integer idMascota;
    DTOPersonaPublicacion rescatista;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    TipoMascota tipoMascota;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    TamanioMascota tamanioMascota;
    String descripcionFisica;
    DTOUbicacionMascota ubicacion;
    List<String> foto;//TODO: ---> Lista de Fotos!

    //Constructors


    public DTOMascotaPerdida(Integer idMascota, DTOPersonaPublicacion rescatista, TipoMascota tipoMascota, TamanioMascota tamanioMascota, String descripcionFisica, DTOUbicacionMascota ubicacion) {
        this.idMascota = idMascota;
        this.rescatista = rescatista;
        this.tipoMascota = tipoMascota;
        this.tamanioMascota = tamanioMascota;
        this.descripcionFisica = descripcionFisica;
        this.ubicacion = ubicacion;
    }

    public DTOMascotaPerdida(MascotaRescatada mr) {
        this.idMascota = mr.getIdMascotaRescatada();
        this.rescatista = new DTOPersonaPublicacion(mr.getPersona());
        this.tipoMascota = mr.getTipoMascota();
        this.tamanioMascota = mr.getTamanioMascota();
        this.descripcionFisica = mr.getDescripcion();
        this.ubicacion = new DTOUbicacionMascota(mr.getUbicacionMascotaRescatadas());
        this.foto = mr.getMascotaFotos().stream().map(MascotaFoto::getValorFoto).collect(Collectors.toList());
    }

    //getters and setters

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public DTOPersonaPublicacion getRescatista() {
        return rescatista;
    }

    public void setRescatista(DTOPersonaPublicacion rescatista) {
        this.rescatista = rescatista;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(TipoMascota tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public TamanioMascota getTamanioMascota() {
        return tamanioMascota;
    }

    public void setTamanioMascota(TamanioMascota tamanioMascota) {
        this.tamanioMascota = tamanioMascota;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }

    public DTOUbicacionMascota getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(DTOUbicacionMascota ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getFoto() {
        return foto;
    }

    public void setFoto(List<String> foto) {
        this.foto = foto;
    }
}
