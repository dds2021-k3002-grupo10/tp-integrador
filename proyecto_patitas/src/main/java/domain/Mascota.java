package domain;

import domain.entities.caracteristicas.Caracteristicas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mascota {
    private Persona duenio;
    private TipoDeMascota tipoDeMascota;
    private String nombre;
    private String apodo;
    private int edad;
    private Sexo sexo;
    private String descripcionFisica;
    private List<Foto> fotos;
    private HashMap<Caracteristicas, String> caracteristicas = new HashMap<>();

    public Mascota(Persona duenio, TipoDeMascota tipoDeMascota, String nombre, String apodo, int edad, Sexo sexo, String descripcionFisica) {
        this.duenio = duenio;
        this.tipoDeMascota = tipoDeMascota;
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
        this.sexo = sexo;
        this.descripcionFisica = descripcionFisica;
        this.fotos = new ArrayList<>();
        this.caracteristicas = new HashMap<>();
    }

    //Accessors

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }

    public TipoDeMascota getTipoDeMascota() {
        return tipoDeMascota;
    }

    public void setTipoDeMascota(TipoDeMascota tipoDeMascota) {
        this.tipoDeMascota = tipoDeMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getDescripcionFisica() {
        return descripcionFisica;
    }

    public void setDescripcionFisica(String descripcionFisica) {
        this.descripcionFisica = descripcionFisica;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public HashMap<Caracteristicas, String> getCaracteristicas() {
        return this.caracteristicas;
    }

    public void setCaracteristicas(HashMap<Caracteristicas, String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    //Funcionalidad
    public void agregarCaracteristica(Caracteristicas caracteristica, String valor) {
        this.caracteristicas.put(caracteristica, valor);
    }

    public void agregarFoto(Foto foto) {
        this.fotos.add(foto);
    }

}
