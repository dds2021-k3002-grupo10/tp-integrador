package com.disenio.services.usuarios.impl;

import com.disenio.dao.usuario.UsuarioDAO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.organizacion.OrganizacionService;
import com.disenio.services.usuarios.UsuarioOrganizacionService;
import com.disenio.services.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private UsuarioOrganizacionService usuarioOrganizacionService;
    @Autowired
    private OrganizacionService organizacionService;

    @Override
    public void altaUsuario(Usuario usuario) {
        //Alta usuario
        Usuario rtaUsuario = usuarioDAO.save(usuario);

        //getOrganizacion
        //Optional<Organizacion> rtaOrganizacion = organizacionService.getOrganizacionById(organizacion);

       // usuarioOrganizacionService.alta(rtaUsuario, rtaOrganizacion.get());

    }

    @Override
    public Usuario getByNombre(String nombre) {
        return usuarioDAO.getByNombre(nombre);
    }

    @Override
    public Usuario getById(Integer idUsuario) {
        return usuarioDAO.getById(idUsuario);
    }
}
