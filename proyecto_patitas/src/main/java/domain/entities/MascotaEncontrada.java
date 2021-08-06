package domain.entities;

import domain.Persona;

import java.util.ArrayList;
import java.util.List;

public class MascotaEncontrada {
    private Persona rescatista;
    private String tipoDeMascota;
    private String tamaño;
    private List<String> caracteristicas = new ArrayList<>();
    private Boolean tieneChapita;
    //private Ubicacion ubicacionEncontrada;
    //private List<Foto> fotos;

    public void agregarCaracteristica(String carac){ caracteristicas.add(carac); }

    public void setTipoDeMascota(String tipoMascota) { this.tipoDeMascota = tipoMascota; }

    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public String getTipoDeMascota() { return tipoDeMascota; }

    public String getTamaño() { return tamaño; }


    public List<String> getCaracteristicas() {
        return caracteristicas;
    }
}
