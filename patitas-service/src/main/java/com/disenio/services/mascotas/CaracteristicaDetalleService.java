package com.disenio.services.mascotas;

import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.Mascota;

import java.util.List;


public interface CaracteristicaDetalleService {

    void alta(List<CaracteristicaDetalle> caracteristicaDetalles, Mascota mascota);
}
