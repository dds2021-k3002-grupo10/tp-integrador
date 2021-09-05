package com.disenio.services.caracteristicas.impl;

import com.disenio.dao.ValorDAO;
import com.disenio.entities.caracteristicas.Valor;
import com.disenio.services.caracteristicas.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service()
public class ValorServiceImpl implements ValorService {
    @Autowired
    @Qualifier("ValorDAO")
    private ValorDAO valorDAO;

    @Transactional
    @Override
    public Valor alta(Valor valor) {

        return valorDAO.save(valor);
    }
}
