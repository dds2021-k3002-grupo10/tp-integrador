package services.refugiosApi.entities;

import domain.entities.MascotaEncontrada;
import services.refugiosApi.entities.Ubicacion;

import java.util.ArrayList;
import java.util.Collections;
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

    public boolean seAceptaMascota(MascotaEncontrada mascota){
        return admisiones.isPerro() && mascota.getTipoDeMascota() == "perro" || admisiones.isGato() && mascota.getTipoDeMascota() == "gato";
    }

    public boolean seAceptaTamaño(MascotaEncontrada mascota){
        return this.patio || mascota.getTamaño() == "chica";
    }

    public boolean coincidenCaracteristicas(MascotaEncontrada mascota){
        if(caracteristicas.isEmpty())
            return true;
        else
            return caracteristicas.containsAll(mascota.getCaracteristicas());
        }

    public boolean tieneLugarDisponible() { return lugares_disponibles > 0; }

}