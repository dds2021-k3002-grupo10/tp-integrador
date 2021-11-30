package com.disenio.model.notificacion;

import com.disenio.model.personas.PersonaContacto;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.IOException;

@Entity
@Data
@DiscriminatorValue("email")
public class NotificacionPorEmail extends MedioNotificacion {
    public NotificacionPorEmail() {
        this.descripcion = "EMAIL";
    }

    @Override
    public void notificar(PersonaContacto personaContacto, String msg) {
       /*
        El mail por el momento es un mail personal, pero solo bastaria con crear un mail nuevo
        correspondiente a determinada organizacion y verificarlo por la página de sendgrid
         */
        Email emailOrganizacion = new Email("guillebarnes@gmail.com");
        String asunto = "Nos contactamos con usted desde la organización de mascotas";
        Email emailDelContacto = new Email(personaContacto.getEmail());
        Content contenido = new Content("text/plain", msg);
        Mail mail = new Mail(emailOrganizacion, asunto, emailDelContacto, contenido);

        SendGrid sg = new SendGrid(System.getenv("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")); //token de sendgrid
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

