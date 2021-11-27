package com.disenio.services.usuarios;

import com.disenio.model.usuarios.Usuario;

public interface UsuarioService {

    void altaUsuario(Usuario usuario);

    Usuario getByNombre(String nombre);

    Usuario getById(Integer idUsuario);
}
