package domain;

import domain.mascota.Caracteristica;
import domain.mascota.Sexo;
import domain.mascota.TipoDeMascota;

import java.util.HashMap;

public class Mascota {
    private TipoDeMascota tipoDeMascota;
    private String nombre;
    private String apodo;
    private int edad;
    private Sexo sexo;
    private String descripcionFisica;
    //todo Lista de fotos
    private HashMap<Caracteristica, String> caracteristicas = new HashMap<>();

    public Mascota(TipoDeMascota tipoDeMascota, String nombre, int edad, Sexo sexo) {
        this.tipoDeMascota = tipoDeMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
    }
    public void setApodo(String apodo){ this.apodo = apodo; }

    public void agregarCaracteristica(Caracteristica caracteristica, String valor){
        this.caracteristicas.put(caracteristica, valor);
    }

    public HashMap<Caracteristica, String> getCaracteristicas() { return this.caracteristicas; }
}
