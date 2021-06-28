import views.OrganizacionView;
import views.ViewNuevoUsuario;

import java.io.IOException;

public class main {
   public static void main(String[] args) throws IOException {

       ViewNuevoUsuario ingresarUsuario = new ViewNuevoUsuario();

       //ingresarUsuario.ejecutar();


       /* caracteristicas */
       OrganizacionView organizacionView = new OrganizacionView();

      // organizacionView.agregarCaracteristicas();

       organizacionView.mostrarCaracteristicas();

   }
}

