package com.disenio.services.usuarios;

import com.disenio.model.usuarios.Rol;

import java.util.List;

public interface RolService {

    List<Rol> getAllRol();

    Rol getById(Integer idRol);
}
