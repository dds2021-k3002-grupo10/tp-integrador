package com.disenio.model.publicaciones;

import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.personas.Persona;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_publicacion_adopcion")
public abstract class PublicacionAdopcion extends Publicacion {

    private Cuestionario cuestionario;
    private String descripcion;

    //Constructors
    protected PublicacionAdopcion(Persona autor, String descripcion) {
        super(autor);
        if (descripcion == null) {
            descripcion = "";
        }
        this.descripcion = descripcion;
    }

    public PublicacionAdopcion() {

    }

    //Accessors
    @OneToOne
    @JoinColumn(name = "ID_CUESTIONARIO")
    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }


    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
