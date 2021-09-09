package com.disenio.services.caracteristicas.impl;

import com.disenio.dao.ComportamientoTipoDAO;
import com.disenio.model.caracteristicas.ComportamientoTipo;
import com.disenio.services.caracteristicas.ComportamientoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class ComportamientoTipoServiceImpl implements ComportamientoTipoService {
    @Autowired
    @Qualifier("ComportamientoTipoDAO")
    private ComportamientoTipoDAO comportamientoTipoDAO;


    @Override
    public List<ComportamientoTipo> getComportamientoTipoAll() {

        return comportamientoTipoDAO.findAll();
    }
}
