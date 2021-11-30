package com.disenio.dto.usuario;

import com.disenio.model.usuarios.Rol;

public class UsuarioDTO {
    String usuario;
    String clave;
    Integer idUsuario;
    Integer idPersona;
    Rol rol;
    String mensaje;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String usuario, String clave, Integer idUsuario, Integer idPersona, Rol rol, String mensaje) {
        this.usuario = usuario;
        this.clave = clave;
        this.idUsuario = idUsuario;
        this.idPersona = idPersona;
        this.rol = rol;
        this.mensaje = mensaje;
    }

    public UsuarioDTO(String usuario, String clave, String mensaje) {
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }

    public UsuarioDTO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
