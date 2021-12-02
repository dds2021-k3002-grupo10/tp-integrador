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

        Email emailOrganizacion = new Email("dalderete@frba.utn.edu.ar");
        String asunto = "Nos contactamos con usted desde la organización de mascotas";
        Email emailDelContacto = new Email(personaContacto.getEmail());
        Content contenido = new Content("text/plain", msg);
        Mail mail = new Mail(emailOrganizacion, asunto, emailDelContacto, contenido);

        SendGrid sg = new SendGrid("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"); //token de sendgrid
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println("Enviando mail");
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

