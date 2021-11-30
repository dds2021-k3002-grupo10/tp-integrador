package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.MascotaRescatadaDAO;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.services.mascotas.MascotaRescatadaService;
import com.disenio.services.mascotas.UbicacionMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MascotaRescatadaImpl implements MascotaRescatadaService {
    @Autowired
    private MascotaRescatadaDAO mascotaDAO;
    @Autowired
    private UbicacionMascotaService ubicacionMascotaService;


    @Override
    public Optional<MascotaRescatada> getById(int id) {
        Optional<MascotaRescatada> mascota = mascotaDAO.findById(id);

        return mascota;
    }

    @Transactional
    @Override
    public void alta(MascotaRescatada mascotaRescatada) {
        ubicacionMascotaService.alta(mascotaRescatada.getUbicacionMascotaRescatadas());
        mascotaDAO.save(mascotaRescatada);
    }

}
