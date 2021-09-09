package com.disenio.services.caracteristicas.impl;

import com.disenio.dao.CaracteristicaDAO;
import com.disenio.model.caracteristicas.Caracteristica;
import com.disenio.model.caracteristicas.CaracteristicaValor;
import com.disenio.model.caracteristicas.Valor;
import com.disenio.services.caracteristicas.CaracteristicaService;
import com.disenio.services.caracteristicas.CaracteristicaValorService;
import com.disenio.services.caracteristicas.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
