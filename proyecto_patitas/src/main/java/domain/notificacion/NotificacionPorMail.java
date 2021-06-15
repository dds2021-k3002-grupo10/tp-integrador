package domain.notificacion;

import domain.Contacto;

public class NotificacionPorMail implements MedioDeNotificacion{
    @Override
    public void notificar(Contacto contacto) {
        //todo utilizar twilio para notificar por mail
    }
}
