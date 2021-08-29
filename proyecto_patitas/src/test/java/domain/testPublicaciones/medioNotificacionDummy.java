package domain.testPublicaciones;

import domain.Contacto;
import domain.notificacion.MedioDeNotificacion;

public class medioNotificacionDummy implements MedioDeNotificacion {

    @Override
    public void notificar(Contacto contacto, String mensaje) {
        System.out.println("Enviando mensaje a:" + contacto.getNombre());
        System.out.println("con el mensaje: " + mensaje);
    }
}
