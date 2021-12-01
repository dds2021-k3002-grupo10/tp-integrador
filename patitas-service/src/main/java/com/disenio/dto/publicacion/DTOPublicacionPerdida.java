package com.disenio.dto.publicacion;

import com.disenio.dto.mascota.DTOMascotaPerdida;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.publicaciones.PublicacionPerdida;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DTOPublicacionPerdida implements Serializable {
    Integer idPublicacion;
    Date fechaPublicacion;
    DTOPersonaPublicacion autor;
    DTOMascotaPerdida mascota;
    Integer idHogar;
    String descripcion;


    //Constructores


    public DTOPublicacionPerdida(Integer idPublicacion, Date fechaPublicacion, DTOPersonaPublicacion autor, DTOMascotaPerdida mascota, Integer idHogar, String descripcion) {
        this.idPublicacion = idPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.mascota = mascota;
        this.idHogar = idHogar;
        this.descripcion = descripcion;
    }

    public DTOPublicacionPerdida(PublicacionPerdida pp) {
        MascotaRescatada mr = pp.getMascota();
        this.idPublicacion = pp.getIdPublicacion();
        this.fechaPublicacion = pp.getFecha();
        this.autor = new DTOPersonaPublicacion(pp.getAutor());
        this.mascota = new DTOMascotaPerdida(mr);
        this.idHogar = pp.getMascota().getUbicacionMascotaRescatadas().getIdHogar();
        this.descripcion = mr.getDescripcion();
    }

    //Getters and Setters

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public DTOPersonaPublicacion getAutor() {
        return autor;
    }

    public void setAutor(DTOPersonaPublicacion autor) {
        this.autor = autor;
    }

    public DTOMascotaPerdida getMascota() {
        return mascota;
    }

    public void setMascota(DTOMascotaPerdida mascota) {
        this.mascota = mascota;
    }

    public Integer getIdHogar() {
        return idHogar;
    }

    public void setIdHogar(Integer idHogar) {
        this.idHogar = idHogar;
    }
}
