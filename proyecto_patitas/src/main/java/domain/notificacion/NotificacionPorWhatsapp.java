package domain.notificacion;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import domain.Contacto;

public class NotificacionPorWhatsapp implements MedioDeNotificacion{
    @Override
    public void notificar(Contacto contacto, String mensaje) {
        Twilio.init(account_sid, auth_token);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + contacto.getTelefono()),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                mensaje)
                .create();
    }
}
