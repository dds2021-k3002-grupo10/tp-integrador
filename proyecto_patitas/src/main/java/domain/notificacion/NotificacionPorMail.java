package domain.notificacion;

import domain.Contacto;
import domain.DetallePersona;

public class NotificacionPorMail implements MedioDeNotificacion{
    @Override
    public void notificar(DetallePersona dueno) {
        //todo utilizar twilio para notificar por mail
    }
}
