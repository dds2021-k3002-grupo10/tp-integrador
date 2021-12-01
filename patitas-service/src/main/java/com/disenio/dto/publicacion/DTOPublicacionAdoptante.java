package com.disenio.dto.publicacion;

import com.disenio.dto.cuestionario.DTOCuestionario;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DTOPublicacionAdoptante implements Serializable {
    Integer idPublicacion;
    Date fechaPublicacion;
    DTOPersonaPublicacion autor;
    DTOCuestionario cuestionario;
    String descripcion;

    //Constructors

    public DTOPublicacionAdoptante(Integer idPublicacion, Date fechaPublicacion, DTOPersonaPublicacion autor, String descripcion) {
        this.idPublicacion = idPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    public DTOPublicacionAdoptante(PublicacionAdoptante pa) {
        this.idPublicacion = pa.getIdPublicacion();
        this.fechaPublicacion = pa.getFecha();
        this.autor = new DTOPersonaPublicacion(pa.getAutor());
        this.descripcion = pa.getDescripcion();
        this.cuestionario = new DTOCuestionario(pa.getCuestionario());
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

    public DTOPersonaPublicacion getAutor() {
        return autor;
    }

    public void setAutor(DTOPersonaPublicacion autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DTOCuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(DTOCuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }
}
