package com.disenio.services.personas.impl;

import com.disenio.dao.persona.MedioNotificacionDAO;
import com.disenio.model.notificacion.MedioNotificacion;
import com.disenio.services.personas.MedioNotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedioNotificacionServiceImpl implements MedioNotificacionService {
    @Autowired
    MedioNotificacionDAO medioNotificacionDAO;

    @Override
    public List<MedioNotificacion> getMedioNotificacionALl() {
        return medioNotificacionDAO.findAll(Sort.by(Sort.Direction.ASC, "idMedioNotificacion"));
    }

    @Override
    public MedioNotificacion getMedioNotificacionByID(int id) {
        return medioNotificacionDAO.getById(id);
    }
}
