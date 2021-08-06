package domain.testFiltroHogares;

import domain.entities.MascotaEncontrada;
import domain.services.FiltroHogares;
import org.junit.Assert;
import org.junit.Test;
import services.refugiosApi.entities.Hogar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFiltroHogares {
    @Test
    public void son8HogaresQueAceptanPerros() throws IOException {
        MascotaEncontrada perroEncontrado = new MascotaEncontrada();
        perroEncontrado.setTipoDeMascota("perro");
        perroEncontrado.setTamaño("grande");
        perroEncontrado.agregarCaracteristica("Lindo");
        FiltroHogares filtroHogares = new FiltroHogares();
        List<Hogar> posiblesHogares = filtroHogares.filtrarPorCaracteristicas(perroEncontrado);
        Assert.assertEquals(7, posiblesHogares.size());
    }

}
