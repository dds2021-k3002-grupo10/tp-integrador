package com.disenio.services.mascotas;

import com.disenio.model.caracteristicas.CaracteristicaDetalle;
import com.disenio.model.caracteristicas.CaracteristicaDetalleValor;

import java.util.List;

public interface CaracteristicaDetalleValorService {

    void alta(List<CaracteristicaDetalleValor> caracteristicaDetalleValors, CaracteristicaDetalle caracteristicaDetalle);
}
