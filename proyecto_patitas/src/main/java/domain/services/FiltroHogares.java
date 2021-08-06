package domain.services;

import domain.entities.MascotaEncontrada;
import services.refugiosApi.ServicioRefugios;
import services.refugiosApi.entities.Hogar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroHogares {

    public List<Hogar> filtrarPorTipoMascota(MascotaEncontrada mascota) throws IOException {
        List<Hogar> hogaresDisponibles = this.getHogares();
        List<Hogar> posiblesHogares = hogaresDisponibles.stream().filter(hogar -> hogar.seAceptaMascota(mascota)).collect(Collectors.toList());
        return posiblesHogares;
    }

    public List<Hogar> filtarPorTamaño(MascotaEncontrada mascota) throws IOException {
        List<Hogar> hogaresFiltrados = this.filtrarPorTipoMascota(mascota);
        List<Hogar> posiblesHogares = hogaresFiltrados.stream().filter(hogar -> hogar.seAceptaTamaño(mascota)).collect(Collectors.toList());
        return posiblesHogares;
    }

    private List<Hogar> getHogares() throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();
        List<Hogar> hogares = apiRefugios.listadoDeRefugios(1).hogares;
        return hogares;
    }

}
