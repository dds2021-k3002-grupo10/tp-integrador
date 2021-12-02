package com.disenio.services.mascotas.impl;

import com.disenio.dao.faq.FaqDAO;
import com.disenio.dao.mascotas.CaracteristicaDetalleDAO;
import com.disenio.dto.mascota.AltaCaracteristicasMascotaDTO;
import com.disenio.model.faq.Faq;
import com.disenio.model.faq.FaqRespuestaValor;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.Mascota;
import com.disenio.services.faq.FaqRespuestaValorService;
import com.disenio.services.mascotas.CaracteristicaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CaracteristicaDetalleServiceImpl implements CaracteristicaDetalleService {

    @Autowired
    CaracteristicaDetalleDAO caracteristicaDetalleDAO;
    @Autowired
    FaqRespuestaValorService faqRespuestaValorService;
    @Autowired
    FaqDAO faqDAO;


    @Transactional
    @Override
    public void alta(List<AltaCaracteristicasMascotaDTO> caracteristicaDetalles, Mascota mascota) {
        if (!caracteristicaDetalles.isEmpty()) {
            /*fechaActual*/
            Date date = new Date();
            for (AltaCaracteristicasMascotaDTO altaCaracteristicasMascotaDTO : caracteristicaDetalles) {

                CaracteristicaDetalle caracteristicaDetalle = new CaracteristicaDetalle();
                //caracteristicaDetalle.setMascota(mascota);
                mascota.addCaracteristica(caracteristicaDetalle);
                caracteristicaDetalle.setFechaAlta(date);
                caracteristicaDetalle.setEstado('A');
                caracteristicaDetalle.setFechaUltimaModificacion(date);

                Optional<Faq> faq = faqDAO.findById(altaCaracteristicasMascotaDTO.getIdFaq());
                caracteristicaDetalle.setFaq(faq.get());
                List<FaqRespuestaValor> faqRespuestaValors = altaCaracteristicasMascotaDTO.getAltaValorMascotaDTOlist().stream()
                        .map(altaValorMascotaDTO ->
                                faqRespuestaValorService.getById(altaValorMascotaDTO.getIdRespuesta())
                        ).collect(Collectors.toList());

                caracteristicaDetalle.setFaqRespuestaValor(faqRespuestaValors);

                caracteristicaDetalleDAO.save(caracteristicaDetalle);

                /*alta valores de respuesta de caracteristicas*/
                //TODO:VER ACA

                //caracteristicaDetalleValorService.alta(altaCaracteristicasMascotaDTO.getAltaValorMascotaDTOlist(), rtaCaracteristicaDetalle);

            }
        }

    }
}
