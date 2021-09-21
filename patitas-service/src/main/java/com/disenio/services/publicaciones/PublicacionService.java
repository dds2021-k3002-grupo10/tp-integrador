package com.disenio.services.publicaciones;

import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.RepositoryService;

import java.util.List;

public interface PublicacionService extends RepositoryService<Publicacion, Integer> {

    public List<PublicacionPerdida> listarPerdidas();

    public List<PublicacionAdoptante> listarAdoptante();

    public List<PublicacionDarAdopcion> listarDarAdopcion();


}