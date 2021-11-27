package com.disenio.services.organizacion.impl;

import com.disenio.dao.organizacion.OrganizacionDAO;
import com.disenio.dto.organizacion.OrganizacionDTO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.services.organizacion.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizacionServiceImpl implements OrganizacionService {
    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    OrganizacionDAO organizacionDAO;

    @Override
    public Optional<Organizacion> getOrganizacionById(Integer id) {
        return organizacionDAO.findById(id);
    }

    @Override
    public List<OrganizacionDTO> getOrganizacionAll() {
        List<Organizacion> organizacion = organizacionDAO.findAll(Sort.by(Sort.Direction.ASC, "idOrganizacion"));

        List<OrganizacionDTO> organizacionDTO = new ArrayList<OrganizacionDTO>();

        if (!organizacion.isEmpty()) {
            organizacionDTO = Arrays.asList(modelMapper.map(organizacion, OrganizacionDTO[].class));
        }
        return organizacionDTO;

    }


}
