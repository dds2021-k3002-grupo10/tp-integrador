package domain.usuario.roles;

import domain.usuario.Rol;

public class Estandar implements Rol {
    private String descripcion;

    @Override
    public Boolean permisoEdicion() { return false; }

    @Override
    public Boolean permisoAprobacion() { return false; }

    @Override
    public String descripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){ this.descripcion = descripcion; }
}
