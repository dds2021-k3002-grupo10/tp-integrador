package domain.entities.caracteristicas;

import java.util.List;

public class Caracteristicas {
    private Long id;
    private String descripcionFaq;
    private TipoSeleccion tipoSeleccion;
    private List<Valores> valores;
    private int orden;
    private Long idOrganizacion;
    private String tipo;

    public Caracteristicas() {
    }

    public Caracteristicas(Long id, String descripcionFaq, TipoSeleccion tipoSeleccion, List<Valores> valores, int orden, Long idOrganizacion) {
        this.id = id;
        this.descripcionFaq = descripcionFaq;
        this.tipoSeleccion = tipoSeleccion;
        this.valores = valores;
        this.orden = orden;
        this.idOrganizacion = idOrganizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcionFaq() {
        return descripcionFaq;
    }

    public void setDescripcionFaq(String descripcionFaq) {
        this.descripcionFaq = descripcionFaq;
    }

    public TipoSeleccion getComportamiento() {
        return tipoSeleccion;
    }

    public void setComportamiento(TipoSeleccion tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

    public List<Valores> getValores() {
        return valores;
    }

    public void setValores(List<Valores> valores) {
        this.valores = valores;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Long getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Long idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

}
