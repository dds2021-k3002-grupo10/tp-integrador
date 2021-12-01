package com.disenio.services.mascotas.impl;

import com.disenio.dao.faq.FaqDAO;
import com.disenio.dao.mascotas.CaracteristicaDetalleDAO;
import com.disenio.dto.mascota.AltaCaracteristicasMascotaDTO;
import com.disenio.model.faq.Faq;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.Mascota;
import com.disenio.services.mascotas.CaracteristicaDetalleService;
import com.disenio.services.mascotas.CaracteristicaDetalleValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CaracteristicaDetalleServiceImpl implements CaracteristicaDetalleService {

    @Autowired
    CaracteristicaDetalleDAO caracteristicaDetalleDAO;
    @Autowired
    FaqDAO faqDAO;
    @Autowired
    CaracteristicaDetalleValorService caracteristicaDetalleValorService;

    @Transactional
    @Override
    public void alta(List<AltaCaracteristicasMascotaDTO> caracteristicaDetalles, Mascota mascota) {
        if (!caracteristicaDetalles.isEmpty()) {
            /*fechaActual*/
            Date date = new Date();
            for (AltaCaracteristicasMascotaDTO altaCaracteristicasMascotaDTO : caracteristicaDetalles) {

                CaracteristicaDetalle caracteristicaDetalle = new CaracteristicaDetalle();
                caracteristicaDetalle.setMascota(mascota);
                caracteristicaDetalle.setFechaAlta(date);
                caracteristicaDetalle.setEstado('A');
                caracteristicaDetalle.setFechaUltimaModificacion(date);

                Optional<Faq> faq = faqDAO.findById(altaCaracteristicasMascotaDTO.getIdFaq());
                caracteristicaDetalle.setFaq(faq.get());

                CaracteristicaDetalle rtaCaracteristicaDetalle = caracteristicaDetalleDAO.save(caracteristicaDetalle);

                /*alta valores de respuesta de caracteristicas*/
                caracteristicaDetalleValorService.alta(altaCaracteristicasMascotaDTO.getAltaValorMascotaDTOlist(), rtaCaracteristicaDetalle);

            }
        }

    }
}
