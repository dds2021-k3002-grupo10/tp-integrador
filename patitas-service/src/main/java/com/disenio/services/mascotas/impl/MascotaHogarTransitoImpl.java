package com.disenio.services.mascotas.impl;

import com.disenio.dao.mascotas.HogarTransitoDAO;
import com.disenio.dao.mascotas.MascotaDAO;
import com.disenio.model.mascotas.MascotaHogarTransito;
import com.disenio.services.mascotas.HogarTransitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MascotaHogarTransitoImpl implements HogarTransitoService {
    @Autowired
    private HogarTransitoDAO hogarTransitoDAO;

    @Override
    public MascotaHogarTransito alta(MascotaHogarTransito o) {
        if(o == null){
            System.out.println("*****************************************");
        }
        return hogarTransitoDAO.save(o);
    }

    @Override
    public List<MascotaHogarTransito> listarTodas() {
        return hogarTransitoDAO.findAll();
    }

    @Override
    public Optional<MascotaHogarTransito> getById(Integer id) {
        return hogarTransitoDAO.findById(id);
    }
}
