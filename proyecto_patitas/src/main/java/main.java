import domain.Mascota;
import domain.mascota.Caracteristica;
import domain.mascota.Sexo;
import domain.mascota.TipoDeMascota;
import views.ViewNuevoUsuario;

public class main {
   public static void main(String[] args) {

       //ViewNuevoUsuario ingresarUsuario = new ViewNuevoUsuario();

       //ingresarUsuario.ejecutar();

       Caracteristica colorDeOjos = new Caracteristica("Color de ojos");
       Caracteristica castrado = new Caracteristica("Castrado");
       Caracteristica colorPrincipal = new Caracteristica("Color principal");
       TipoDeMascota perro = new TipoDeMascota();
       Mascota perro1 = new Mascota(perro, "Gino", 5, Sexo.MACHO);
       perro1.agregarCaracteristica(colorDeOjos, "marron");
       perro1.agregarCaracteristica(castrado, "no");
       perro1.agregarCaracteristica(colorPrincipal, "marron claro");

       for (Caracteristica caracteristica : perro1.getCaracteristicas().keySet()) {
           System.out.println(caracteristica.getDescripcion() + ": " + perro1.getCaracteristicas().get(caracteristica));
       }
   }
}

