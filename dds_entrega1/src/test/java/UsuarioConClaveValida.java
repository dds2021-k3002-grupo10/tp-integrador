import domain.CriterioClaveDebil;
import domain.CriterioRegex;
import domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioConClaveValida {
    @Test
    /**
     * Si un usuario tiene una contraseña clave tiene una mayuscula, minuscula y un numero
     * Tiene mas de 8 digitos
     * Y no aparece entre las peores 10 mil contraseñas
     **/

    public void usuarioConClaveValida(){
        Usuario user4 = new Usuario("user4", "Diseno2021");

        CriterioRegex criterioRegex = new CriterioRegex();
        criterioRegex.criteriosRegex();

        CriterioClaveDebil criterioClaveDebil = new CriterioClaveDebil();
        criterioClaveDebil.levantarContrasenasDebiles();

        Boolean contraseniaValida = criterioRegex.esClaveValida(user4.getContrasenia()) &&
                                                criterioClaveDebil.esClaveValida(user4.getContrasenia());

        Assert.assertTrue(contraseniaValida);
    }
     }
