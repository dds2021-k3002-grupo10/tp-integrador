package com.disenio.services.API.refugiosApi.entities;

import com.disenio.model.mascotas.MascotaRescatada;

import java.util.ArrayList;
import java.util.List;

public class Hogar {
    public String id;
    public String nombre;
    public Ubicacion ubicacion;
    public String telefono;
    public Admision admisiones;
    public int capacidad;
    public int lugares_disponibles;
    public boolean patio;
    public List<String> caracteristicas = new ArrayList<>();

    public boolean seAceptaMascota(MascotaRescatada mascota) {
        return admisiones.isPerro() && mascota.getTipoMascota().getNombre().equalsIgnoreCase("perro") || admisiones.isGato() && mascota.getTipoMascota().getNombre().equalsIgnoreCase("gato") ;
    }

    public boolean seAceptaTamaño(MascotaRescatada mascota) {
        return this.patio || mascota.getTamanioMascota().getDescripcion().equalsIgnoreCase("chica");
    }

    public boolean coincidenCaracteristicas(MascotaRescatada mascota) {
        if (caracteristicas.isEmpty())
            return true;
        else
            //return caracteristicas.containsAll(mascota.getCaracteristicas());
            return false;//TODO: HARDCODE
    }

    public boolean tieneLugarDisponible() {
        return lugares_disponibles > 0;
    }

}