package domain.notificacion;

import domain.Contacto;

public class NotificacionPorSms implements MedioDeNotificacion{
    @Override
    public void notificar(Contacto contacto) {
        //todo utilizar twilio para notificar por sms
    }
}
