package com.disenio.services.cuestionarios.impl;

import com.disenio.dao.cuestionario.CuestionarioDAO;
import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.services.cuestionarios.CuestionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {
    @Autowired
    CuestionarioDAO cuestionarioDAO;

    @Override
    public Cuestionario getById(Integer id) {
        return cuestionarioDAO.getById(id);
    }

    @Override
    public List<Cuestionario> getCuestionarioAll() {
        return cuestionarioDAO.findAll();
    }

    @Override
    public void alta(Cuestionario cuestionario) {
        cuestionarioDAO.save(cuestionario);
    }
}
