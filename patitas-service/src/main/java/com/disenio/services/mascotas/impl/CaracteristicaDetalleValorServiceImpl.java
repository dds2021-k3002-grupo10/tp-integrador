package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.CaracteristicaDetalleValorDAO;
import com.disenio.dto.mascota.AltaValorMascotaDTO;
import com.disenio.model.faq.FaqRespuestaValor;
import com.disenio.model.mascotas.CaracteristicaDetalle;
import com.disenio.model.mascotas.CaracteristicaDetalleValor;
import com.disenio.services.faq.FaqRespuestaValorService;
import com.disenio.services.mascotas.CaracteristicaDetalleValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CaracteristicaDetalleValorServiceImpl implements CaracteristicaDetalleValorService {

    @Autowired
    CaracteristicaDetalleValorDAO caracteristicaDetalleValorDAO;
    @Autowired
    FaqRespuestaValorService faqRespuestaValorService;

    @Transactional
    @Override
    public void alta(List<AltaValorMascotaDTO> altaValorMascotaDTOList, CaracteristicaDetalle caracteristicaDetalle) {

        for (AltaValorMascotaDTO altaValorMascotaDTO : altaValorMascotaDTOList) {
            CaracteristicaDetalleValor caracteristicaDetalleValor = new CaracteristicaDetalleValor();

            caracteristicaDetalleValor.setCaracteristicaDetalle(caracteristicaDetalle);
            caracteristicaDetalleValor.setEstado('A');

            FaqRespuestaValor faqRespuestaValor = faqRespuestaValorService.getById(altaValorMascotaDTO.getIdRespuesta());
            caracteristicaDetalleValor.setFaqRespuestaValor(faqRespuestaValor);

            caracteristicaDetalleValorDAO.save(caracteristicaDetalleValor);
        }

    }
}
