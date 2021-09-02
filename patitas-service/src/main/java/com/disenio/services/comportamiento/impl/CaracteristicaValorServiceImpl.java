package com.disenio.services.comportamiento.impl;

import com.disenio.dao.CaracteristicaDAO;
import com.disenio.dao.CaracteristicaValorDAO;
import com.disenio.entities.caracteristicas.CaracteristicaValor;
import com.disenio.services.comportamiento.CaracteristicaValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service()
public class CaracteristicaValorServiceImpl implements CaracteristicaValorService {
    @Autowired
    @Qualifier("CaracteristicaValorDAO")
    private CaracteristicaValorDAO caracteristicaValorDAO;


    @Override
    public CaracteristicaValor alta(CaracteristicaValor caracteristicaValor) {

        return caracteristicaValorDAO.save(caracteristicaValor);
    }
}
