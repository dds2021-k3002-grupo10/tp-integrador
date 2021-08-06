package domain.testFiltroHogares;

import domain.entities.MascotaEncontrada;
import domain.services.FiltroHogares;
import org.junit.Assert;
import org.junit.Test;
import services.refugiosApi.entities.Hogar;

import java.io.IOException;
import java.util.List;

public class TestFiltroHogares {
    @Test
    public void son9HogaresQueAceptanPerros() throws IOException {
        MascotaEncontrada perroEncontrado = new MascotaEncontrada();
        perroEncontrado.setTipoDeMascota("perro");
        perroEncontrado.setTamaño("grande");
        FiltroHogares filtroHogares = new FiltroHogares();
        List<Hogar> posiblesHogares = filtroHogares.filtarPorTamaño(perroEncontrado);
        Assert.assertEquals(8, posiblesHogares.size());
    }
}
