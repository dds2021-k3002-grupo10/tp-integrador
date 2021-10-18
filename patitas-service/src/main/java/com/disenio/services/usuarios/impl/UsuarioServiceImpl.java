package com.disenio.services.usuarios.impl;

import com.disenio.dao.persona.PersonaDAO;
import com.disenio.dao.usuario.UsuarioDAO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.personas.Persona;
import com.disenio.model.usuarios.Usuario;
import com.disenio.model.usuarios.UsuarioOrganizacion;
import com.disenio.services.organizacion.OrganizacionService;
import com.disenio.services.organizacion.impl.OrganizacionServiceImpl;
import com.disenio.services.usuarios.UsuarioOrganizacionService;
import com.disenio.services.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
        Usuario rtaUsuario= usuarioDAO.save(usuario);

        //getOrganizacion
        Optional<Organizacion> rtaOrganizacion = organizacionService.getOrganizacionById(usuario.getUsuarioOrganizacions().get(0).getOrganizacion().getIdOrganizacion());

        usuarioOrganizacionService.alta(rtaUsuario, rtaOrganizacion.get());

    }

    @Override
    public Usuario getByNombre(String nombre) {
        return usuarioDAO.getByNombre(nombre);
    }
}
