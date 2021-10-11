package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.CaracteristicaDetalleDAO;
import com.disenio.model.caracteristicas.Caracteristica;
import com.disenio.model.caracteristicas.CaracteristicaDetalle;
import com.disenio.model.caracteristicas.CaracteristicaDetalleValor;
import com.disenio.model.mascotas.Mascota;
import com.disenio.services.caracteristicas.CaracteristicaService;
import com.disenio.services.mascotas.CaracteristicaDetalleService;
import com.disenio.services.mascotas.CaracteristicaDetalleValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaDetalleServiceImpl implements CaracteristicaDetalleService {

    @Autowired
    CaracteristicaService caracteristicaService;
    @Autowired
    CaracteristicaDetalleValorService caracteristicaDetalleValorService;
    @Autowired
    CaracteristicaDetalleDAO caracteristicaDetalleDAO;

    @Transactional
    @Override
    public void alta(List<CaracteristicaDetalle> caracteristicaDetalles, Mascota mascota) {
        caracteristicaDetalles.forEach(caracteristicaDetalle -> {
            //Set Mascota
            caracteristicaDetalle.setMascota(mascota);
            //SetCaraceristicas
            Optional<Caracteristica> rtaCaracteristica = caracteristicaService.getCaracteristicaByID(caracteristicaDetalle.getCaracteristica().getIdCaracteristica());

            //AltaCaracteristcaDetalle
            CaracteristicaDetalle rtaCaracteristicaDetalle = caracteristicaDetalleDAO.save(caracteristicaDetalle);

            List<CaracteristicaDetalleValor> caracteristicaDetalleValors = caracteristicaDetalle.getCaracteristicaDetalleValors();
            caracteristicaDetalleValorService.alta(caracteristicaDetalleValors,rtaCaracteristicaDetalle);

        });
    }
}
