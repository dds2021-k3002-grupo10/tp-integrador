package domain;

import domain.entities.caracteristicas.Caracteristicas;
import domain.entities.caracteristicas.Sexo;
import domain.entities.caracteristicas.TipoDeMascota;

import java.util.List;

public class Mascota {
    private TipoDeMascota tipoDeMascota;
    private String nombre;
    private String apodo;
    private int edad;
    private Sexo sexo;
    private String descripcionFisica;
    //todo Lista de fotos
    private List<Caracteristicas> caracteristicas;

    public Mascota(TipoDeMascota tipoDeMascota, String nombre, int edad, Sexo sexo) {
        this.tipoDeMascota = tipoDeMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
    }

    public Mascota() {
    }

    public void setApodo(String apodo){ this.apodo = apodo; }

}
