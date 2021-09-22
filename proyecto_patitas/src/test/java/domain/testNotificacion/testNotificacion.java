package domain.testNotificacion;

import domain.Contacto;
import domain.Documento;
import domain.Persona;
import domain.notificacion.NotificacionPorMail;
import domain.notificacion.NotificacionPorSms;
import domain.notificacion.NotificacionPorWhatsapp;
import org.junit.Test;

import java.util.Date;

public class testNotificacion {

    @Test
    public void pruebaDeNotificacion(){
        Documento dni = new Documento();
        dni.setTipoDocumento("Documento Unico");

        Persona personaPrueba = new Persona("Guillermo Barnes", new Date(12/15/1995), dni, "39340406");

        Contacto contacto1 = new Contacto("Guillermo", "Barnes", "gbarnes@frba.utn.edu.ar", "+5491166742669", new NotificacionPorMail());
        Contacto contacto2 = new Contacto("Guillermo", "Barnes", "gbarnes@frba.utn.edu.ar", "+5491166742669", new NotificacionPorWhatsapp());
        Contacto contacto3 = new Contacto("Guillermo", "Barnes", "gbarnes@frba.utn.edu.ar", "+5491166742669", new NotificacionPorSms());

        personaPrueba.agregarContacto(contacto1);
        personaPrueba.agregarContacto(contacto2);
        personaPrueba.agregarContacto(contacto3);

        personaPrueba.notificar("Se encontro una mascota de su propiedad");
    }





}
