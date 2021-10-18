package com.disenio.services.usuarios;

import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Rol;
import com.disenio.model.usuarios.UsuarioOrganizacion;

public interface UsuarioRolService {

    void alta(Rol rol, UsuarioOrganizacion usuarioOrganizacion);
}
