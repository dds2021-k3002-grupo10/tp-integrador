package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.CaracteristicaDetalleValorDAO;
import com.disenio.model.caracteristicas.*;
import com.disenio.services.caracteristicas.CaracteristicaValorService;
import com.disenio.services.caracteristicas.ValorService;
import com.disenio.services.mascotas.CaracteristicaDetalleValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaDetalleValorServiceImpl implements CaracteristicaDetalleValorService {

    @Autowired
    CaracteristicaDetalleValorDAO caracteristicaDetalleValorDAO;
    @Autowired
    ValorService valorService;
    @Override
    public void alta(List<CaracteristicaDetalleValor> caracteristicaDetalleValors, CaracteristicaDetalle caracteristicaDetalle) {
        caracteristicaDetalleValors.forEach(caracteristicaDetalleValor -> {
            //set caracteristicaDetalleValor
            Valor rtaValor=valorService.getValorByID(caracteristicaDetalleValor.getValor().getIdValor());
            caracteristicaDetalleValor.setValor(rtaValor);
            //set caracteristicaDetalleValor
            caracteristicaDetalleValor.setCaracteristicaDetalle(caracteristicaDetalle);

            //AltaDetalle
            caracteristicaDetalleValorDAO.save(caracteristicaDetalleValor);

        });
    }
}
