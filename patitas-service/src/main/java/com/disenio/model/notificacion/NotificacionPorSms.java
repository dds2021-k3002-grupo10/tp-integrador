package com.disenio.model.notificacion;

import com.disenio.model.personas.PersonaContacto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("sms")
public class NotificacionPorSms extends MedioNotificacion {
    public NotificacionPorSms() {
        this.descripcion = "SMS";
    }

    @Override
    public void notificar(PersonaContacto personaContacto, String msg) {
        final String account_sid = "ACeaa8f461078d22c1151d283f54cafc8a";
        final String auth_token = "87ff46721e8a12dc9ce1158e5c4a3b29";

        Twilio.init(account_sid, auth_token);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(personaContacto.getTelefono().toString()),
                        new com.twilio.type.PhoneNumber("+12674227144"),
                        msg)
                .create();
    }
}
