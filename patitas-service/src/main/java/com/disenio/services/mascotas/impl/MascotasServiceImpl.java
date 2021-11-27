package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.MascotaDAO;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;
import com.disenio.services.mascotas.CaracteristicaDetalleService;
import com.disenio.services.mascotas.MascotaFotoService;
import com.disenio.services.mascotas.MascotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class MascotasServiceImpl implements MascotasService {
    @Autowired
    private MascotaDAO mascotaDAO;
    @Autowired
    private CaracteristicaDetalleService caracteristicaDetalleService;
    @Autowired
    private MascotaFotoService mascotaFotoService;

    @Override
    public Optional<Mascota> getById(int id) {
        Optional<Mascota> mascota = mascotaDAO.findById(id);

        return mascota;
    }

    @Transactional
    @Override
    public void alta(List<Mascota> mascotas, Persona persona) {
        mascotas.forEach(mascota -> {
            mascota.setPersona(persona);
            //AltaMascota
            Mascota rtaMascota = mascotaDAO.save(mascota);

            mascotaFotoService.alta(mascota.getMascotaFotos(), rtaMascota);

            caracteristicaDetalleService.alta(mascota.getCaracteristicaDetalles(), rtaMascota);

        });

    }

    @Override
    public List<Mascota> getMascotasAll() {
        return mascotaDAO.findAll();
    }
}
