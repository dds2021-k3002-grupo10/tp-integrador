package domain.usuario;

import domain.Persona;

public class Usuario {
    private String usuario;
    private String clave;
    private Rol rol;
    private Persona persona;

    public Usuario(String usuario, String clave, Rol rol) {
        this.usuario = usuario;
        this.clave = clave;
        this.rol = rol;
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


}
