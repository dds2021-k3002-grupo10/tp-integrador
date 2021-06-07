package domain.usuario.roles;

import domain.usuario.Rol;

public class Admin implements Rol {
    private String descripcion;

    @Override
    public Boolean tienePermiso() {
        return true;
    }

    @Override
    public String descripcion() {
        return this.descripcion;
    }
}
