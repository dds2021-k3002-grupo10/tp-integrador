package domain.publicacion;

import domain.Persona;

public abstract class PublicacionAdopcion extends Publicacion {

    protected Cuestionario cuestionario;

    //constructor

    protected PublicacionAdopcion(Persona creadoPor, Cuestionario cuestionario) {
        super(creadoPor);
        this.cuestionario = cuestionario;
    }

    //Accessors
    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

}
