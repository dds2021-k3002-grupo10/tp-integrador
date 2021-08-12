package domain.notificacion;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import domain.Contacto;

public class NotificacionPorSms implements MedioDeNotificacion{


    @Override
    public void notificar(Contacto contacto, String mensaje) {
        Twilio.init(account_sid, auth_token);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(contacto.getTelefono()),
                new com.twilio.type.PhoneNumber("+19039103018"),
                mensaje)
                .create();
    }
}
