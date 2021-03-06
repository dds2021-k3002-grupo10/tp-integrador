package domain.testApi;

import org.junit.Assert;
import org.junit.Test;
import services.refugiosApi.ServicioRefugios;
import services.refugiosApi.entities.Hogar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestApi {
    @Test
    public void elTotalDeHogaresCon1OffsetEsDe40() throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();
        Assert.assertEquals(40, apiRefugios.listadoDeRefugios(1).total);
    }
    @Test
    public void elNombreDelPrimerHogarEsPensionadoDeMascotasComoEnCasa() throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();
        List<Hogar> hogares = new ArrayList<>();
        hogares = apiRefugios.listadoDeRefugios(1).hogares;
        Assert.assertEquals("Pensionado de mascotas \"Como en casa\"", hogares.get(0).nombre);
    }
    @Test
    public void elPrimerHogarSoloAceptaGatos() throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();
        List<Hogar> hogares = apiRefugios.listadoDeRefugios(1).hogares;
        Assert.assertEquals(true, hogares.get(0).admisiones.isGato());
    }
    @Test
    public void laPrimerCaracteristicaDelPrimerHogarEsTranquilo() throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();
        List<Hogar> hogares = apiRefugios.listadoDeRefugios(1).hogares;
        List<String> caracteristicas = hogares.get(0).caracteristicas;
        Assert.assertEquals("Tranquilo", caracteristicas.get(0));
    }
}
