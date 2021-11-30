package com.disenio.services.API.refugiosApi.entities;

import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.services.API.refugiosApi.ServicioRefugios;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ListadoDeRefugios {
    public int total;
    public int offset;
    public List<Hogar> hogares;

    private List<Hogar> getHogares() throws IOException {
        ServicioRefugios apiRefugios = ServicioRefugios.getInstancia();
        List<Hogar> hogares = apiRefugios.listadoDeRefugios(1).hogares;
        return hogares;
    }

    public List<Hogar> filtroPorMascota(MascotaRescatada mascota) throws IOException {
        List<Hogar> hogaresFiltrados = this.getHogares();

        hogaresFiltrados = this.filtrarPorDisponibilidad(hogaresFiltrados, mascota);

        hogaresFiltrados = this.filtrarPorTipoMascota(hogaresFiltrados, mascota);

        hogaresFiltrados = this.filtrarPorTamaño(hogaresFiltrados, mascota);

        hogaresFiltrados = this.filtrarPorCaracteristicas(hogaresFiltrados, mascota);

        return hogaresFiltrados;
    }

    public List<Hogar> filtrarPorDisponibilidad(List<Hogar> hogares, MascotaRescatada mascota) {
        List<Hogar> hogaresDisponibles = hogares;
        List<Hogar> posiblesHogares = hogaresDisponibles.stream().filter(hogar -> hogar.tieneLugarDisponible()).collect(Collectors.toList());
        return posiblesHogares;
    }

    public List<Hogar> filtrarPorTipoMascota(List<Hogar> hogares, MascotaRescatada mascota) {
        List<Hogar> hogaresFiltrados = hogares;
        List<Hogar> posiblesHogares = hogaresFiltrados.stream().filter(hogar -> hogar.seAceptaMascota(mascota)).collect(Collectors.toList());

        return posiblesHogares;
    }

    public List<Hogar> filtrarPorTamaño(List<Hogar> hogares, MascotaRescatada mascota) {
        List<Hogar> hogaresFiltrados = hogares;
        List<Hogar> posiblesHogares = hogaresFiltrados.stream().filter(hogar -> hogar.seAceptaTamaño(mascota)).collect(Collectors.toList());
        return posiblesHogares;
    }

    public List<Hogar> filtrarPorCaracteristicas(List<Hogar> hogares, MascotaRescatada mascota) throws IOException {
        List<Hogar> hogaresFiltrados = hogares;
        List<Hogar> posiblesHogares = hogaresFiltrados.stream().filter(hogar -> hogar.coincidenCaracteristicas(mascota)).collect(Collectors.toList());
        return posiblesHogares;
    }

}
