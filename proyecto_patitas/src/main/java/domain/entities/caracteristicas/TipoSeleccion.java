package domain.entities.caracteristicas;

public class TipoSeleccion {


    private Long id;
    private String descripcion;

    public TipoSeleccion() {
    }

    public TipoSeleccion(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
