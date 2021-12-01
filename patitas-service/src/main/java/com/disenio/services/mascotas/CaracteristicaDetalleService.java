package com.disenio.services.mascotas;

import com.disenio.dto.mascota.AltaCaracteristicasMascotaDTO;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.Mascota;

import java.util.List;


public interface CaracteristicaDetalleService {

    void alta(List<AltaCaracteristicasMascotaDTO> caracteristicaDetalles, Mascota mascota);
}
