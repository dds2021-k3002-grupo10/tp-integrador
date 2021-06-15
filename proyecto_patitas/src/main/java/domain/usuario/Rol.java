package domain.usuario;

public interface Rol {
    public Boolean permisoEdicion();

    public Boolean permisoAprobacion();

    public String descripcion();
}
