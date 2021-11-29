package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.TamanioMascotaDAO;
import com.disenio.dao.mascotas.TipoMascotaDAO;
import com.disenio.model.mascotas.TamanioMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.services.mascotas.TamanioMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TamanioMascotaServiceImpl implements TamanioMascotaService {
    @Autowired
    TamanioMascotaDAO tamanioMascotaDAO;


    @Override
    public Optional<TamanioMascota> getById(int id) {
        return tamanioMascotaDAO.findById(id);
    }

    @Override
    public List<TamanioMascota> getAllTamanioMascota() {
        return tamanioMascotaDAO.findAll();
    }
}
