package com.disenio.dto.usuario;

import com.disenio.model.usuarios.Rol;

public class UsuarioAltaDTO {
    String usuario;
    String clave;
    //String rol;
    String mensaje;


    public UsuarioAltaDTO(String usuario, String clave, String mensaje) {
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }

    public UsuarioAltaDTO(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public UsuarioAltaDTO() {
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

   /* public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    */
}
