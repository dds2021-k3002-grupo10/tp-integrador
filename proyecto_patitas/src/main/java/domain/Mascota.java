package domain;

import domain.entities.caracteristicas.Caracteristicas;
import domain.entities.caracteristicas.Sexo;
import domain.entities.caracteristicas.TipoDeMascota;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private TipoDeMascota tipoDeMascota;
    private String nombre;
    private String apodo;
    private int edad;
    private Sexo sexo;
    private String descripcionFisica;
    private Persona dueño;
    //todo Lista de fotos
    private List<Caracteristicas> caracteristicas = new ArrayList<>();

    public Mascota(TipoDeMascota tipoDeMascota, String nombre, int edad, Sexo sexo, String apodo, Persona dueño) {
        this.tipoDeMascota = tipoDeMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.dueño = dueño;
    }

    public Mascota() {
    }

    public void agregarCaracteristica(Caracteristicas caracateristica){ this.caracteristicas.add(caracateristica); }

}
