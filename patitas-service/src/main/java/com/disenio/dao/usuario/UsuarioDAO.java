package com.disenio.dao.usuario;

import com.disenio.model.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario,Integer> {

    @Query("Select a from Usuario a where a.nombre = :nombre")
    Usuario getByNombre(String nombre);
}
