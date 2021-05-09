import domain.CriterioRegex;
import domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioConClaveSinNumero {
    @Test
    public void UsuarioConClaveSinNumero(){
        Usuario user2 = new Usuario("user2", "AAAAaaaaAAAA");
        CriterioRegex criterioRegex = new CriterioRegex();
        criterioRegex.criteriosRegex();

        Assert.assertFalse(criterioRegex.esClaveValida(user2.getContrasenia()));
    }
}
