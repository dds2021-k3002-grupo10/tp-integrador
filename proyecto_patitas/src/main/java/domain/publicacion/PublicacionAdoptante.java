package domain.publicacion;

import domain.Persona;

public class PublicacionAdoptante extends Publicacion {
    private Persona adoptante;
    //private preguntas:List<Preguntas>


    public PublicacionAdoptante(Persona adoptante) {
        this.adoptante = adoptante;
    }

    public Persona getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Persona adoptante) {
        this.adoptante = adoptante;
    }

    @Override
    public void contactar() {

    }

    @Override
    public Persona creadoPor() {
        return adoptante;
    }
}
