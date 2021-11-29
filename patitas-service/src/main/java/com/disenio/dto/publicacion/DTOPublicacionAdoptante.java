package com.disenio.dto.publicacion;

import com.disenio.dto.persona.DTOPersona;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DTOPublicacionAdoptante implements Serializable {
    Integer idPublicacion;
    Date fechaPublicacion;
    DTOPersona autor;
    String descripcion;

    //Constructors

    public DTOPublicacionAdoptante(Integer idPublicacion, Date fechaPublicacion, DTOPersona autor, String descripcion) {
        this.idPublicacion = idPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public DTOPublicacionAdoptante(PublicacionAdoptante pa) {
        this.idPublicacion = pa.getIdPublicacion();
        this.fechaPublicacion = pa.getFecha();
        this.autor = new DTOPersona(pa.getAutor());
        this.descripcion = pa.getDescripcion();
    }

    //GETTERS AND SETTERS
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
