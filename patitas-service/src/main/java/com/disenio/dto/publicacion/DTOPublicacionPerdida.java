package com.disenio.dto.publicacion;

import com.disenio.dto.mascota.DTOMascotaPerdida;
import com.disenio.dto.persona.DTOPersona;
import com.disenio.model.Views;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DTOPublicacionPerdida implements Serializable {
    @JsonView(Views.External.class)
    Integer idPublicacion;
    @JsonView(Views.External.class)
    Date fechaPublicacion;
    @JsonView(Views.External.class)
    DTOPersona autor;
    @JsonView(Views.External.class)
    DTOMascotaPerdida mascota;
    @JsonView(Views.External.class)
    Integer idHogar;
    @JsonView(Views.External.class)
    String descripcion;


    //Constructores


    public DTOPublicacionPerdida(Integer idPublicacion, Date fechaPublicacion, DTOPersona autor, DTOMascotaPerdida mascota, Integer idHogar, String descripcion) {
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
        this.autor = new DTOPersona(pp.getAutor());
        this.mascota = new DTOMascotaPerdida(mr);
        this.idHogar = pp.getHogar().getIdHogar();
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

    public DTOPersona getAutor() {
        return autor;
    }

    public void setAutor(DTOPersona autor) {
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
