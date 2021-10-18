package com.disenio.dao.usuario;

import com.disenio.model.caracteristicas.Caracteristica;
import com.disenio.model.usuarios.UsuarioOrganizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioOrganizacionDAO extends JpaRepository<UsuarioOrganizacion, Integer> {

    @Query("Select a from UsuarioOrganizacion a where a.organizacion.idOrganizacion= :idOrganizacion and a.usuario.idUsuario= :idUsuario")
    UsuarioOrganizacion getByIdUsuarioAndIdOrganizacion(Integer idUsuario, Integer idOrganizacion);


}
