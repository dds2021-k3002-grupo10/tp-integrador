package com.disenio.dao.usuario;

import com.disenio.model.usuarios.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolDAO extends JpaRepository<UsuarioRol, Integer> {
}
