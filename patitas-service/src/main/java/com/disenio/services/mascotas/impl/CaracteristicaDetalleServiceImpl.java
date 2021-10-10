package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.CaracteristicaDetalleDAO;
import com.disenio.model.caracteristicas.Caracteristica;
import com.disenio.model.caracteristicas.CaracteristicaDetalle;
import com.disenio.model.caracteristicas.CaracteristicaValor;
import com.disenio.model.mascotas.Mascota;
import com.disenio.services.caracteristicas.CaracteristicaService;
import com.disenio.services.caracteristicas.CaracteristicaValorService;
import com.disenio.services.mascotas.CaracteristicaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaDetalleServiceImpl implements CaracteristicaDetalleService {
    @Autowired
    CaracteristicaDetalleDAO caracteristicaDetalleDAO;
    @Autowired
    CaracteristicaService caracteristicaService;
    @Autowired
    CaracteristicaValorService caracteristicaValorService;
    @Transactional
    @Override
    public void alta(List<CaracteristicaDetalle> caracteristicaDetalles, Mascota mascota) {
        caracteristicaDetalles.forEach(caracteristicaDetalle -> {

            caracteristicaDetalle.setMascota(mascota);
            //SetCaraceristicas
           // Optional<Caracteristica> rtaCaracteristica = caracteristicaService.getCaracteristicaByID(caracteristicaDetalle.getCaracteristica().getIdCaracteristica());
            //caracteristicaDetalle.setCaracteristica(rtaCaracteristica.get());
            //SetCaracteristicaValores

            //AltaCaracteristcaDetalle
            caracteristicaDetalleDAO.save(caracteristicaDetalle);
        });
    }
}
