package com.disenio.services.usuarios.impl;

import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.organizacion.OrganizacionService;
import com.disenio.services.usuarios.UsuarioOrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Deprecated
@Service
public class UsuarioOrganizacionServiceImpl implements UsuarioOrganizacionService {
   /* @Autowired
    UsuarioOrganizacionDAO usuarioOrganizacionDAO;
    */

    @Autowired
    OrganizacionService organizacionService;


    @Override
    public void alta(Usuario usuario, Organizacion organizacion) {

        organizacion.addUsuario(usuario);
        organizacionService.alta(organizacion);

    }
/*
    @Override
    public UsuarioOrganizacion getByIdUsuarioAndIdOrganizacion(Integer idUsuario, Integer idOrganizacion) {
        return usuarioOrganizacionDAO.getByIdUsuarioAndIdOrganizacion(idUsuario,idOrganizacion);
    }
    */

}
