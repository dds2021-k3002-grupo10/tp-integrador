package domain.publicacion;

import domain.Persona;

import java.time.LocalDate;

public abstract class Publicacion {
    protected LocalDate fecha;
    protected Persona autor;
    protected long id;    //TODO: ---> Posible AtomicInteger

    //Constructor
    protected Publicacion(Persona creadoPor) {
        this.fecha = LocalDate.now();
        this.autor = creadoPor;
        this.id = 0;//TODO: -> Revisar para hacerlo atomico
    }

    //Accessors
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //Funcionalidad
    public void contactar(Persona solicitante) {
        String mensaje = "Hola " + autor.getNombre() + "! Te contamos que" + solicitante.getNombre() + "quiere contactarte por la publicacion " + id;
        autor.notificar(mensaje);
    }
}
