package com.disenio.services.organizacion.impl;

import com.disenio.dao.organizacion.OrganizacionDAO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.services.organizacion.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
    @Autowired
    OrganizacionDAO organizacionDAO;
    @Override
    public Optional<Organizacion> getOrganizacionById(Integer id) {
        return organizacionDAO.findById(id);
    }
}
