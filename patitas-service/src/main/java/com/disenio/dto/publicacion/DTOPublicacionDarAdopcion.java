package com.disenio.dto.publicacion;

import com.disenio.dto.cuestionario.DTOCuestionario;
import com.disenio.dto.mascota.DTOMascota;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DTOPublicacionDarAdopcion implements Serializable {

    Integer idPublicacion;
    Date fechaPublicacion;
    DTOPersonaPublicacion autor;
    DTOCuestionario cuestionario;
    DTOMascotaPublicacion mascota;
    String descripcion;

    //Constructors

    public DTOPublicacionDarAdopcion(Integer idPublicacion, Date fechaPublicacion, DTOPersonaPublicacion autor, DTOMascotaPublicacion mascota, String descripcion) {
        this.idPublicacion = idPublicacion;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.mascota = mascota;
        this.descripcion = descripcion;
    }

    public DTOPublicacionDarAdopcion(PublicacionDarAdopcion publicacion) {
        this.idPublicacion = publicacion.getIdPublicacion();
        this.fechaPublicacion = publicacion.getFecha();
        this.autor = new DTOPersonaPublicacion(publicacion.getAutor());
        this.mascota = new DTOMascotaPublicacion(publicacion.getMascotaOfrecida());
        this.descripcion = publicacion.getDescripcion();
        this.cuestionario = new DTOCuestionario(publicacion.getCuestionario());
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

    public DTOPersonaPublicacion getAutor() {
        return autor;
    }

    public void setAutor(DTOPersonaPublicacion autor) {
        this.autor = autor;
    }

    public DTOMascotaPublicacion getMascota() {
        return mascota;
    }

    public void setMascota(DTOMascotaPublicacion mascota) {
        this.mascota = mascota;
    }

    public DTOCuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(DTOCuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
