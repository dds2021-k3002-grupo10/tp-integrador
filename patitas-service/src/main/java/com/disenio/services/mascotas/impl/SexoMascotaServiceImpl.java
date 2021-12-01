package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.SexoMascotaDAO;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.services.mascotas.SexoMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexoMascotaServiceImpl implements SexoMascotaService {
    @Autowired
    SexoMascotaDAO sexoMascotaDAO;
    @Override
    public List<SexoMascota> getAllSexoMascota() {
        return sexoMascotaDAO.findAll();
    }

    @Override
    public SexoMascota getById(Integer idSexo) {
        return sexoMascotaDAO.getById(idSexo);
    }
}
