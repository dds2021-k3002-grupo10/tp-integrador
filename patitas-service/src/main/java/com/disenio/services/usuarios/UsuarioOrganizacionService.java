package com.disenio.services.usuarios;

import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.model.usuarios.UsuarioOrganizacion;

public interface UsuarioOrganizacionService {

    void alta(Usuario usuario, Organizacion organizacion);

    UsuarioOrganizacion getByIdUsuarioAndIdOrganizacion(Integer idUsuario, Integer idOrganizacion);
}
