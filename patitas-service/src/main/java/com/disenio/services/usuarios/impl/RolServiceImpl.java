package com.disenio.services.usuarios.impl;

import com.disenio.dao.usuario.RolDAO;
import com.disenio.model.usuarios.Rol;
import com.disenio.services.usuarios.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolDAO rolDAO;
    @Override
    public List<Rol> getAllRol() {
        return rolDAO.findAll();
    }

    @Override
    public Rol getById(Integer idRol) {
        return rolDAO.getById(idRol);
    }
}
