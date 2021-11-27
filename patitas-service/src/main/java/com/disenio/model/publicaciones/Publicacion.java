package com.disenio.model.publicaciones;

import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "publicacion", catalog = "patitas"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_publicacion")
public abstract class Publicacion implements Serializable {

    private Integer idPublicacion;
    private Date fecha;
    private Persona autor;

    //Constructors


    public Publicacion() {
    }

    protected Publicacion(Persona autor) {
        this.autor = autor;
        this.fecha = Date.from(Instant.now());
    }

    //Accessors


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_PUBLICACION", unique = true, nullable = false)
    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_PUBLICACION", nullable = false, length = 0)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = true)//TODO CAMBIAR
    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    //Funcionalidad
    public abstract void contactar();

}
