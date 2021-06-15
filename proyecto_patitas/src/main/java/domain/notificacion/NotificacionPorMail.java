package domain.notificacion;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import domain.Contacto;
import domain.DetallePersona;

import java.io.IOException;

public class NotificacionPorMail implements MedioDeNotificacion{
    @Override
    public void notificar(Contacto contacto) {
        Email emailOrganizacion = new Email("org@ejemplo.com");
        String asunto = "Se ha encontrado una mascota perdida";
        Email emailDelContacto = new Email(contacto.getEmail());
        Content contenido = new Content("text/plain", "Se encontro una mascota perdida y se notifica a la persona para ponerse en contacto con el correspondiente.");
        Mail mail = new Mail(emailOrganizacion, asunto, emailDelContacto, contenido);

        SendGrid sg = new SendGrid(System.getenv("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")); //token de sendgrid
        Request request = new Request();
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
