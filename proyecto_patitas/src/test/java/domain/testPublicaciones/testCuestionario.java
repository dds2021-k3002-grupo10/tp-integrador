package domain.testPublicaciones;

import domain.publicacion.EntradaCuestionario;
import domain.publicacion.GestorDePublicaciones;
import org.junit.Assert;
import org.junit.Test;

public class testCuestionario {
    GestorDePublicaciones gestorDePublicaciones1 = new GestorDePublicaciones();
    GestorDePublicaciones gestorDePublicaciones2 = new GestorDePublicaciones();

    @Test
    public void testGestorPublicacion() {
        EntradaCuestionario entradaCuestionario = new EntradaCuestionario("pregunta", false, false);
        EntradaCuestionario entradaCuestionario2 = new EntradaCuestionario("pregunta2", false, false);

        gestorDePublicaciones1.getCuestionarioOrganizacionDeAdopcion().agregarEntrada(entradaCuestionario);

        gestorDePublicaciones2.getCuestionarioOrganizacionDeAdopcion().agregarEntrada(entradaCuestionario2);


        Assert.assertNotSame(gestorDePublicaciones1.getCuestionarioOrganizacionDeAdopcion().getPreguntas(), gestorDePublicaciones2.getCuestionarioOrganizacionDeAdopcion().getPreguntas());

    }


}
