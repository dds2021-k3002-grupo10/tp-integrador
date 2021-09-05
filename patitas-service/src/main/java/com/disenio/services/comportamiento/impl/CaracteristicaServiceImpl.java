package com.disenio.services.comportamiento.impl;

import com.disenio.dao.CaracteristicaDAO;
import com.disenio.dao.ComportamientoTipoDAO;
import com.disenio.entities.caracteristicas.Caracteristica;
import com.disenio.entities.caracteristicas.CaracteristicaValor;
import com.disenio.entities.caracteristicas.Valor;
import com.disenio.services.comportamiento.CaracteristicaService;
import com.disenio.services.comportamiento.CaracteristicaValorService;
import com.disenio.services.comportamiento.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service()
public class CaracteristicaServiceImpl implements CaracteristicaService {

    @Autowired
    @Qualifier("CaracteristicaDAO")
    private CaracteristicaDAO caracteristicaDAO;
    @Autowired
    ValorService valorService;
    @Autowired
    CaracteristicaValorService caracteristicaValorService;

    @Transactional
    @Override
    public void alta(Caracteristica caracteristica) {
        //Alta a caracteristica
        Caracteristica rtaCaracteristica = new Caracteristica();
        rtaCaracteristica = caracteristicaDAO.save(caracteristica);


        for (CaracteristicaValor caracteristicaValor : caracteristica.getCaracteristicaValors()) {

            //Alta a valor
            Valor rdoValor = valorService.alta(caracteristicaValor.getValor());

            caracteristicaValor.setCaracteristica(rtaCaracteristica);
            caracteristicaValor.setValor(rdoValor);

            //Alta a caracteristicaValor
            caracteristicaValorService.alta(caracteristicaValor);
        }


    }

    @Override
    public List<Caracteristica> getCaracteristicaAll() {
        return caracteristicaDAO.findAll();
    }

    @Override
    public List<Caracteristica> getCaracteristicaByOrganizacionId(Integer idOrganizacion) {
        return caracteristicaDAO.findByOrganizacion_IdOrganizacion(idOrganizacion);
    }
}
