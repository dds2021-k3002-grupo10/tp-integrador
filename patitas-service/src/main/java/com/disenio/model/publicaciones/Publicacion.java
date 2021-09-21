package com.disenio.model.publicaciones;

import com.disenio.model.Views;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "publicacion"
        , catalog = "patitas"
)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_publicacion")
public abstract class Publicacion implements Serializable {

    @JsonView(Views.External.class)
    private Integer idPublicacion;
    @JsonView(Views.External.class)
    private Date fecha;
    @JsonView(Views.External.class)
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

    @Temporal(TemporalType.DATE)
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
