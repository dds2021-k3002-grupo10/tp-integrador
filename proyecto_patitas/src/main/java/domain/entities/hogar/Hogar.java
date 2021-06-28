package domain.entities.hogar;

import java.util.List;

public class Hogar {

    private String id;
    private UbicacionHogar ubicacion;
    private String telefono;
    private AdmisionHogar admisiones;
    private int capacidad;
    private int lugares_disponibles;
    private boolean patio;
    private List<String> caracteristicas;

    public Hogar() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UbicacionHogar getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionHogar ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public AdmisionHogar getAdmisiones() {
        return admisiones;
    }

    public void setAdmisiones(AdmisionHogar admisiones) {
        this.admisiones = admisiones;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getLugares_disponibles() {
        return lugares_disponibles;
    }

    public void setLugares_disponibles(int lugares_disponibles) {
        this.lugares_disponibles = lugares_disponibles;
    }

    public boolean isPatio() {
        return patio;
    }

    public void setPatio(boolean patio) {
        this.patio = patio;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
