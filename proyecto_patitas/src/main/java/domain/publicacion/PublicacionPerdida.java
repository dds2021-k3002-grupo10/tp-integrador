package domain.publicacion;

import domain.Persona;
import domain.entities.MascotaEncontrada;
import services.refugiosApi.entities.Hogar;

public class PublicacionPerdida extends Publicacion {
    private Estado estado;
    private MascotaEncontrada mascota;
    private Hogar hogar;

    public PublicacionPerdida(Persona creadoPor, Estado estado, MascotaEncontrada mascota, Hogar hogar) {
        super(creadoPor);
        this.estado = estado;
        this.mascota = mascota;
        this.hogar = hogar;
    }

//Accessors

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public MascotaEncontrada getMascota() {
        return mascota;
    }

    public void setMascota(MascotaEncontrada mascota) {
        this.mascota = mascota;
    }

    public Hogar getHogar() {
        return hogar;
    }

    public void setHogar(Hogar hogar) {
        this.hogar = hogar;
    }

    //Funcionalidad
    public void aprobar() {
        this.estado = Estado.APROBADO;
    }

    public void rechazar() {
        this.estado = Estado.APROBADO;
    }
}
