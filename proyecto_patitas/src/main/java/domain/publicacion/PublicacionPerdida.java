package domain.publicacion;

import domain.Persona;
import domain.entities.MascotaEncontrada;
import services.refugiosApi.entities.Hogar;

public class PublicacionPerdida extends Publicacion{

    private MascotaEncontrada mascota;
    private Hogar hogar;

    public PublicacionPerdida(MascotaEncontrada mascota, Hogar hogar) {
        this.mascota = mascota;
        this.hogar = hogar;
    }
    //Accessors
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
    @Override
    public void contactar() {
        /*TODO:
           - Mensaje notificacion-> Potencia String---> "Se encontro al dueño"
       */
        Persona rescatista = mascota.getRescatista();
        rescatista.notificar();
    }

    @Override
    public Persona creadoPor() {
        return mascota.getRescatista();
    }
}
