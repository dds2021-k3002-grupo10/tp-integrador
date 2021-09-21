package com.disenio.services.publicaciones.impl;

import com.disenio.dao.PublicacionDAO;
import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.publicaciones.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
public class PublicacionServiceImpl implements PublicacionService {
    @Autowired
    @Qualifier("PublicacionDAO")
    private PublicacionDAO publicacionDAO;

    @Transactional
    @Override
    public Publicacion alta(Publicacion persona) {

        return publicacionDAO.save(persona);

    }

    @Override
    public List<Publicacion> listarTodas() {
        return publicacionDAO.findAll();
    }


    @Override
    public Optional<Publicacion> getById(Integer id) {
        Optional<Publicacion> publicacion = publicacionDAO.findById(id);

        return publicacion;
    }

    @Override
    public List<PublicacionPerdida> listarPerdidas() {
        return this.listarTodas().stream().
                filter(publicacion -> publicacion instanceof PublicacionPerdida).
                map(publicacion -> (PublicacionPerdida) publicacion).
                collect(Collectors.toList());
    }

    @Override
    public List<PublicacionDarAdopcion> listarDarAdopcion() {
        return this.listarTodas().stream().
                filter(publicacion -> publicacion instanceof PublicacionDarAdopcion).
                map(publicacion -> (PublicacionDarAdopcion) publicacion).
                collect(Collectors.toList());
    }

    @Override
    public List<PublicacionAdoptante> listarAdoptante() {
        return this.listarTodas().stream().
                filter(publicacion -> publicacion instanceof PublicacionAdoptante).
                map(publicacion -> (PublicacionAdoptante) publicacion).
                collect(Collectors.toList());
    }
}
