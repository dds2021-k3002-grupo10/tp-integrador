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

    public void setTipoDeMascota(String tipoMascota) { this.tipoDeMascota = tipoMascota; }

    public void setTamaño(String tamaño) { this.tamaño = tamaño; }

    public String getTipoDeMascota() { return tipoDeMascota; }

    public String getTamaño() { return tamaño; }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void notificar(){
        if(this.tieneChapita){
            //Se debería notificar al dueño de la mascota, conocida por el codigo QR
        }
        else
            rescatista.notificar("Se ha encontrado un posible dueño de la mascota encontrada");
    }
}
