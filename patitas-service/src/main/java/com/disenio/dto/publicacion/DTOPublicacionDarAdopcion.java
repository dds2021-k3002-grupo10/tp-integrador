package com.disenio.dto.publicacion;

import com.disenio.dto.mascota.DTOMascota;
import com.disenio.dto.persona.DTOPersona;
import com.disenio.model.Views;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DTOPublicacionDarAdopcion implements Serializable {

    @JsonView(Views.External.class)
    Integer idPublicacion;
    @JsonView(Views.External.class)
    Date fechaPublicacion;
    @JsonView(Views.External.class)
    DTOPersona autor;
    @JsonView(Views.External.class)
    DTOMascota mascota;
    @JsonView(Views.External.class)
    String descripcion;

    //Constructors

    public DTOPublicacionDarAdopcion(Integer idPublicacion, Date fechaPublicacion, DTOPersona autor, DTOMascota mascota, String descripcion) {
        this.idPublicacion = idPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.mascota = mascota;
        this.descripcion = descripcion;
    }

    public  DTOPublicacionDarAdopcion(PublicacionDarAdopcion publicacion){
        this.idPublicacion = publicacion.getIdPublicacion();
        this.fechaPublicacion = publicacion.getFecha();
        this.autor = new DTOPersona(publicacion.getAutor());
        this.mascota = new DTOMascota(publicacion.getMascotaOfrecida());
        this.descripcion = publicacion.getDescripcion();
    }

    //Getters and setters

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

    public DTOMascota getMascota() {
        return mascota;
    }

    public void setMascota(DTOMascota mascota) {
        this.mascota = mascota;
    }
}
