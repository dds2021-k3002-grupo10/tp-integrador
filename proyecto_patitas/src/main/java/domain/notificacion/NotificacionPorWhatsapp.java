package domain.notificacion;

import domain.Contacto;

public class NotificacionPorWhatsapp implements MedioDeNotificacion{
    @Override
    public void notificar(Contacto contacto) {
        //todo utilizar twilio para notificar por whatsapp
    }
}
