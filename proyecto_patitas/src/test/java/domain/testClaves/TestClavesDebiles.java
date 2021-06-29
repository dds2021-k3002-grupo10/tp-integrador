package domain.testClaves;

import org.junit.Assert;
import org.junit.Test;
import security.services.ValidadorDeClave;

public class TestClavesDebiles {
    @Test
    public void unaClaveCortaEsDebil(){
        String claveDePrueba = "hola123";
        ValidadorDeClave validador = new ValidadorDeClave();
        Assert.assertFalse(validador.esClaveValida(claveDePrueba));
    }

    @Test
    public void unaClaveSinNumerosEsDebil(){
        String claveDePrueba = "ProbandoUnaClave";
        ValidadorDeClave validador = new ValidadorDeClave();
        Assert.assertFalse(validador.esClaveValida(claveDePrueba));
    }
    @Test
    public void unaClaveSinMayusculasEsDebil(){
        String claveDePrueba = "clavelargasinmayusculas123";
        ValidadorDeClave validador = new ValidadorDeClave();
        Assert.assertFalse(validador.esClaveValida(claveDePrueba));
    }
    @Test
    public void unaClaveQueEstaEntreLas10MilPeoresEsDebil(){
        String claveDePrueba = "Qwerty123";
        ValidadorDeClave validador = new ValidadorDeClave();
        Assert.assertFalse(validador.esClaveValida(claveDePrueba));
    }
    @Test
    public void unaClaveConNumerosMayusculasYOchoCaracteresEsFuerte(){
        String claveDePrueba = "Prueba12";
        ValidadorDeClave validador = new ValidadorDeClave();
        Assert.assertTrue(validador.esClaveValida(claveDePrueba));
    }
}
