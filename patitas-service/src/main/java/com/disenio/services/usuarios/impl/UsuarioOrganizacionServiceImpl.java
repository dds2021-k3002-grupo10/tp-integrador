package com.disenio.services.usuarios.impl;

import com.disenio.dao.usuario.UsuarioOrganizacionDAO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.model.usuarios.UsuarioOrganizacion;
import com.disenio.services.usuarios.UsuarioOrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioOrganizacionServiceImpl implements UsuarioOrganizacionService {
    @Autowired
    UsuarioOrganizacionDAO usuarioOrganizacionDAO;


    @Override
    public void alta(Usuario usuario, Organizacion organizacion) {

        UsuarioOrganizacion usuarioOrganizacion = new UsuarioOrganizacion();
        usuarioOrganizacion.setUsuario(usuario);
        usuarioOrganizacion.setOrganizacion(organizacion);
        usuarioOrganizacion.setEstado('A');

        usuarioOrganizacionDAO.save(usuarioOrganizacion);
    }

    @Override
    public UsuarioOrganizacion getByIdUsuarioAndIdOrganizacion(Integer idUsuario, Integer idOrganizacion) {
        return usuarioOrganizacionDAO.getByIdUsuarioAndIdOrganizacion(idUsuario,idOrganizacion);
    }
}
