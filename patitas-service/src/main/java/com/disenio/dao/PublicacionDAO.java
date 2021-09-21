package com.disenio.dao;

import com.disenio.model.publicaciones.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PublicacionDAO")
public interface PublicacionDAO extends JpaRepository<Publicacion, Integer> {
}
