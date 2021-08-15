import domain.Contacto;
import domain.entities.MascotaEncontrada;
import domain.notificacion.NotificacionPorSms;
import domain.services.FiltroHogares;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import services.refugiosApi.ServicioRefugios;
import services.refugiosApi.entities.Hogar;
import views.OrganizacionView;
import views.ViewNuevoUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
   public static void main(String[] args) throws IOException, SchedulerException {



//       ViewNuevoUsuario ingresarUsuario = new ViewNuevoUsuario();

       //ingresarUsuario.ejecutar();


       /* caracteristicas */
      /*
       OrganizacionView organizacionView = new OrganizacionView();

       organizacionView.agregarCaracteristicas();

       organizacionView.mostrarCaracteristicas();
      */


      /*
      NotificacionPorSms sms = new NotificacionPorSms();
      Contacto contacto1 = new Contacto("Guillermo", "Barnes", "guillebarnes@gmail.com", "+5491166742669", sms);

      contacto1.notificar();
      */
   }
}

