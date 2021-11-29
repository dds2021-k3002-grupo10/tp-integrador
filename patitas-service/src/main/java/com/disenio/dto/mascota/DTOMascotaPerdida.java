package com.disenio.dto.mascota;

import com.disenio.dto.persona.DTOPersona;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.mascotas.TamanioMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
public class DTOMascotaPerdida implements Serializable {
    Integer idMascota;
    DTOPersona rescatista;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    TipoMascota tipoMascota;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    TamanioMascota tamanioMascota;
    String descripcionFisica;
    DTOUbicacionMascota ubicacion;

    //Constructors


    public DTOMascotaPerdida(Integer idMascota, DTOPersona rescatista, TipoMascota tipoMascota, TamanioMascota tamanioMascota, String descripcionFisica, DTOUbicacionMascota ubicacion) {
        this.idMascota = idMascota;
        this.rescatista = rescatista;
        this.tipoMascota = tipoMascota;
        this.tamanioMascota = tamanioMascota;
        this.descripcionFisica = descripcionFisica;
        this.ubicacion = ubicacion;
    }

    public DTOMascotaPerdida(MascotaRescatada mr) {
        this.idMascota = mr.getIdMascotaRescatada();
        this.rescatista = new DTOPersona(mr.getPersona());
        this.tipoMascota = mr.getTipoMascota();
        this.tamanioMascota = mr.getTamanioMascota();
        this.descripcionFisica = mr.getDescripcion();
        this.ubicacion = new DTOUbicacionMascota(mr.getUbicacionMascotaRescatadas());
    }

    //getters and setters

    public Integer getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public DTOPersona getRescatista() {
        return rescatista;
    }

    public void setRescatista(DTOPersona rescatista) {
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
}
