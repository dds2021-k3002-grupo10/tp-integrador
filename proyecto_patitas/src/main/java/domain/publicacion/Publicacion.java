package domain.publicacion;

import domain.Persona;

import java.time.LocalDate;

public abstract class Publicacion {
    protected Estado estado;
    protected LocalDate fecha;

    protected Publicacion() {
        this.estado = Estado.PENDIENTE;
        this.fecha = LocalDate.now();
    }

    //Accessors
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //Funcionalidad
    public abstract void contactar();

    public void aprobar() {
        this.estado = Estado.APROBADO;
    }

    public void rechazar() {
        this.estado = Estado.RECHAZADO;
    }


    public abstract Persona creadoPor();
}
