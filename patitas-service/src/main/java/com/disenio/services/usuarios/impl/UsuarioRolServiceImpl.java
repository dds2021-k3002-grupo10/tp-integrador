package com.disenio.services.usuarios.impl;

import com.disenio.dao.usuario.UsuarioRolDAO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Rol;
import com.disenio.model.usuarios.UsuarioOrganizacion;
import com.disenio.model.usuarios.UsuarioRol;
import com.disenio.services.usuarios.UsuarioRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {
    @Autowired
    private UsuarioRolDAO usuarioRolDAO;
    @Override
    public void alta(Rol rol, UsuarioOrganizacion usuarioOrganizacion) {
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuarioOrganizacion(usuarioOrganizacion);
        //alta usuaurioRol
        usuarioRolDAO.save(usuarioRol);
    }
}
