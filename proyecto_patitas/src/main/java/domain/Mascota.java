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
    private HashMap<Caracteristica, String> caracteristicas;

}
