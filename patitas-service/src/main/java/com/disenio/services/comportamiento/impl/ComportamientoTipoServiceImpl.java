package com.disenio.services.comportamiento.impl;

import com.disenio.dao.ComportamientoTipoDAO;
import com.disenio.dao.PersonaDAO;
import com.disenio.entities.caracteristicas.ComportamientoTipo;
import com.disenio.services.comportamiento.ComportamientoTipoService;
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
