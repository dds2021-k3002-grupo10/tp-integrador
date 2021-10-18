package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.TipoMascotaDAO;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.services.mascotas.TipoMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoMascotaServiceImpl implements TipoMascotaService {
    @Autowired
    TipoMascotaDAO tipoMascotaDAO;

    @Override
    public List<TipoMascota> getAllTipoMascota() {
        return tipoMascotaDAO.findAll();
    }
}
