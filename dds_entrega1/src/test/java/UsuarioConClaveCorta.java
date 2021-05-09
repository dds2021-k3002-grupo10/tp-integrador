import domain.CriterioRegex;
import domain.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioConClaveCorta {

    @Test

    public void userConClaveMuyCorta(){
        Usuario user1 = new Usuario("user1", "AaA1");
        CriterioRegex criterioRegex = new CriterioRegex();
        criterioRegex.criteriosRegex();

        Assert.assertFalse(criterioRegex.esClaveValida(user1.getContrasenia()));
    }
}

