package com.disenio.dto.mascota;

import com.disenio.model.Views;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.mascotas.UbicacionMascotaRescatada;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public class DTOUbicacionMascota implements Serializable {
    @JsonView(Views.External.class)
    private Integer idUbicacion;

    @JsonView(Views.External.class)
    private String direccion;

    @JsonView(Views.External.class)
    private Integer latitud;

    @JsonView(Views.External.class)
    private Integer longitud;

    //Constructors
    public DTOUbicacionMascota(Integer idUbicacion, String direccion, Integer latitud, Integer longitud) {
        this.idUbicacion = idUbicacion;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    public DTOUbicacionMascota(UbicacionMascotaRescatada ub) {
        this.idUbicacion = ub.getIdUbicacion();
        this.direccion = ub.getDireccion();
        this.latitud = ub.getLatitud();
        this.longitud = ub.getLongitud();
    }

    //getters and setters

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }
}
