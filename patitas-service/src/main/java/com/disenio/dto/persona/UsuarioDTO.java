package com.disenio.dto.persona;

public class UsuarioDTO {
    String usuario;
    String clave;
    String mensaje;

    public UsuarioDTO(String usuario, String clave, String mensaje) {
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
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
}
