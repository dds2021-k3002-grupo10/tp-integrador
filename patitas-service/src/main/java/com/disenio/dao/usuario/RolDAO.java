package com.disenio.dao.usuario;

import com.disenio.model.usuarios.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDAO extends JpaRepository<Rol, Integer> {
}
