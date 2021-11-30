package com.disenio.services.personas;

import com.disenio.model.notificacion.MedioNotificacion;

import java.util.List;

public interface MedioNotificacionService {

    List<MedioNotificacion> getMedioNotificacionALl();
    MedioNotificacion getMedioNotificacionByID(int id);
}
