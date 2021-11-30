package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.MascotaFotoDAO;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaFoto;
import com.disenio.services.mascotas.MascotaFotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MascotaFotoServiceImpl implements MascotaFotoService {

    @Autowired
    MascotaFotoDAO mascotaFotoDAO;

    @Transactional
    @Override
    public void alta(List<MascotaFoto> mascotaFotos, Mascota mascota) {
        mascotaFotos.forEach(mascotaFoto -> {
            mascota.addFoto(mascotaFoto);
            //AltaMascotaFoto
            mascotaFotoDAO.save(mascotaFoto);
        });
    }
}
