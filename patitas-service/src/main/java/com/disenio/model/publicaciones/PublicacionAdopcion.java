package com.disenio.model.publicaciones;

import com.disenio.model.Views;
import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_publicacion_adopcion")
public abstract class PublicacionAdopcion extends Publicacion {
    @JsonView(Views.External.class)
    private Cuestionario cuestionario;

    //Constructors
    protected PublicacionAdopcion(Persona autor) {
        super(autor);
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

}
