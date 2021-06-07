package domain.usuario.roles;

import domain.usuario.Rol;

public class Estandar implements Rol {
    public String descripcion;

    @Override
    public Boolean tienePermiso() {
        return false;
    }

    @Override
    public String descripcion() {
        return this.descripcion;
    }
}
