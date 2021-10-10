package com.disenio.services.mascotas;

import com.disenio.model.caracteristicas.CaracteristicaDetalle;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaFoto;

import java.util.List;

public interface CaracteristicaDetalleService {

    void alta(List<CaracteristicaDetalle> caracteristicaDetalles, Mascota mascota);
}
