package services.refugiosApi.entities;

import domain.entities.MascotaEncontrada;
import services.refugiosApi.entities.Ubicacion;

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
    public List<String> caracteristicas;

    public boolean seAceptaMascota(MascotaEncontrada mascota){
        return admisiones.isPerro() && mascota.getTipoDeMascota() == "perro" || admisiones.isGato() && mascota.getTipoDeMascota() == "gato";
    }

    public boolean seAceptaTamaño(MascotaEncontrada mascota){
        return this.patio || mascota.getTamaño() == "chica";
    }
}