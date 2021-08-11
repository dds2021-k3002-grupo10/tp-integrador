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


    public MascotaEncontrada(Persona rescatista, String tipoDeMascota, String tamaño, List<String> caracteristicas, Boolean tieneChapita) {
        this.rescatista = rescatista;
        this.tipoDeMascota = tipoDeMascota;
        this.tamaño = tamaño;
        this.caracteristicas = caracteristicas;
        this.tieneChapita = tieneChapita;
    }

    public void agregarCaracteristica(String carac){ caracteristicas.add(carac); }

    public Persona getRescatista() {
        return rescatista;
    }

    public void setRescatista(Persona rescatista) {
        this.rescatista = rescatista;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Boolean getTieneChapita() {
        return tieneChapita;
    }

    public void setTieneChapita(Boolean tieneChapita) {
        this.tieneChapita = tieneChapita;
    }

    public void setTipoDeMascota(String tipoMascota) { this.tipoDeMascota = tipoMascota; }

    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public String getTipoDeMascota() { return tipoDeMascota; }

    public String getTamaño() { return tamaño; }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }
}
