package com.disenio.services.caracteristicas;

import com.disenio.model.caracteristicas.CaracteristicaValor;

public interface CaracteristicaValorService {

    CaracteristicaValor alta(CaracteristicaValor caracteristicaValor);

    CaracteristicaValor getByID(Integer id);
}
