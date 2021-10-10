package com.disenio.services.caracteristicas.impl;

import com.disenio.dao.CaracteristicaValorDAO;
import com.disenio.model.caracteristicas.CaracteristicaValor;
import com.disenio.services.caracteristicas.CaracteristicaValorService;
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

    @Override
    public CaracteristicaValor getByID(Integer id) {
        return caracteristicaValorDAO.getById(id);
    }
}
