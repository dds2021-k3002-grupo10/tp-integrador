package com.disenio.services.mascotas;

import com.disenio.dto.mascota.AltaValorMascotaDTO;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.CaracteristicaDetalleValor;

import java.util.List;

public interface CaracteristicaDetalleValorService {

    void alta(List<AltaValorMascotaDTO> altaValorMascotaDTOList, CaracteristicaDetalle caracteristicaDetalle);
}
