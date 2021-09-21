package com.disenio.model.publicaciones;

import com.disenio.model.Views;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("darAdopcion")
public class PublicacionDarAdopcion extends PublicacionAdopcion {
    @JsonView(Views.External.class)
    private Mascota mascotaOfrecida;

    //Constructors
    protected PublicacionDarAdopcion(Persona autor) {
        super(autor);
    }

    public PublicacionDarAdopcion() {

    }

    //Accessors

    @OneToOne
    @JoinColumn(name = "ID_MASCOTA", nullable = true)
    public Mascota getMascotaOfrecida() {
        return mascotaOfrecida;
    }

    public void setMascotaOfrecida(Mascota mascotaOfrecida) {
        this.mascotaOfrecida = mascotaOfrecida;
    }

    //Funcionalidad
    @Override
    public void contactar() {
        /*TODO Magia para contactar*/
    }
}
