package services.refugiosApi.entities;

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
}