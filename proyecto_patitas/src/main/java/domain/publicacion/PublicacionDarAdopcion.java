package domain.publicacion;

import domain.Mascota;
import domain.Persona;

public class PublicacionDarAdopcion extends Publicacion {
    /*TODO: Preguntas*/
    //private List<Preguntas> preguntas
    private Mascota mascota;


    public void realizarAdopcion(Persona duenioNuevo){
        this.contactar();
    }

    @Override
    public void contactar() {
        //TODO: Magia
        //Persona duenio = mascota.getDuenio();

    }

    @Override
    public Persona creadoPor() {
        return null;
    }
}
