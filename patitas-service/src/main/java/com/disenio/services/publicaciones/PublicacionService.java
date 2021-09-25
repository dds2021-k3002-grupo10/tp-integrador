package com.disenio.services.publicaciones;

import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.model.publicaciones.PublicacionPerdida;

import java.util.List;
import java.util.Optional;

public interface PublicacionService {

    public Publicacion alta(Publicacion o);

    public List<Publicacion> listarTodas();

    public Optional<Publicacion> getById(Integer id);

    public List<PublicacionPerdida> listarPerdidas();

    public List<PublicacionAdoptante> listarAdoptante();

    public List<PublicacionDarAdopcion> listarDarAdopcion();


}