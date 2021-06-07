package domain.usuario;

import domain.DetallePersona;

public class Usuario {
    private String usuario;
    private String clave;
    private Rol rol;
    private DetallePersona detallePersona;

    public Usuario(String usuario, String clave) {
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
}
