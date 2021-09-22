package domain.testFiltroHogares;

import domain.entities.MascotaEncontrada;
import domain.services.FiltroHogares;
import org.junit.Assert;
import org.junit.Test;
import services.refugiosApi.entities.Hogar;
import services.refugiosApi.entities.ListadoDeRefugios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFiltroHogares {
    @Test
    public void son7HogaresQueAceptanPerros() throws IOException {
        List<String> caraceteristicas  = new ArrayList<>();
        MascotaEncontrada perroEncontrado = new MascotaEncontrada(null, "perro", "grande", caraceteristicas, null);
        perroEncontrado.agregarCaracteristica("Agresivo");
        FiltroHogares filtroHogares = new FiltroHogares();
        List<Hogar> posiblesHogares = filtroHogares.filtrarPorCaracteristicas(perroEncontrado);
        Assert.assertEquals(7, posiblesHogares.size());
    }

    @Test
    public void casosDePruebaPerro() throws IOException {
        List<String> caraceteristicas  = new ArrayList<>();
        MascotaEncontrada perroEncontrado = new MascotaEncontrada(null, "perro", "chico", caraceteristicas, null);
        perroEncontrado.agregarCaracteristica("Manso");
        FiltroHogares filtroHogares = new FiltroHogares();
        List<Hogar> posiblesHogares = filtroHogares.filtrarPorCaracteristicas(perroEncontrado);
        Assert.assertEquals(8, posiblesHogares.size());
    }

    @Test
    public void son7HogaresParaUnPerro() throws IOException {
        List<String> caraceteristicas  = new ArrayList<>();
        MascotaEncontrada perroEncontrado = new MascotaEncontrada(null, "perro", "grande", caraceteristicas, null);
        perroEncontrado.agregarCaracteristica("Lindo");
        ListadoDeRefugios listadoDeRefugios = new ListadoDeRefugios();

        Assert.assertEquals(7, listadoDeRefugios.filtroPorMascota(perroEncontrado).size());
    }
}
