package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.UbicacionMascotaDAO;
import com.disenio.model.mascotas.UbicacionMascotaRescatada;
import com.disenio.services.mascotas.UbicacionMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionMascotaImpl implements UbicacionMascotaService {
    @Autowired
    UbicacionMascotaDAO ubicacionMascotaDAO;

    @Override
    public List<UbicacionMascotaRescatada> getAllTipoMascota() {
        return this.ubicacionMascotaDAO.findAll();
    }

    @Override
    public Optional<UbicacionMascotaRescatada> getById(Integer id) {
        return this.ubicacionMascotaDAO.findById(id);
    }

    @Override
    public void alta(UbicacionMascotaRescatada u) {
        this.ubicacionMascotaDAO.save(u);
    }
}
