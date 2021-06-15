package domain.notificacion;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import domain.Contacto;
import domain.DetallePersona;

public class NotificacionPorSms implements MedioDeNotificacion{


    @Override
    public void notificar(Contacto contacto) {
        Twilio.init(account_sid, auth_token);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(contacto.getTelefono()),
                new com.twilio.type.PhoneNumber("+5491112345678"),
                "Se encontro una mascota perdida")
                .create();
    }
}
