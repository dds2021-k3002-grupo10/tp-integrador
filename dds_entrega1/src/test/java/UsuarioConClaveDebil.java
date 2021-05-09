import domain.CriterioClaveDebil;
import domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioConClaveDebil {
    @Test
    public void usuarioConClaveDebil(){

        //dragon es una clave que esta entre las peores 10 mil

        Usuario user3 = new Usuario("user3", "dragon");
        CriterioClaveDebil criterioClaveDebil = new CriterioClaveDebil();
        criterioClaveDebil.levantarContrasenasDebiles();

        Assert.assertFalse(criterioClaveDebil.esClaveValida(user3.getContrasenia()));
    }
}
