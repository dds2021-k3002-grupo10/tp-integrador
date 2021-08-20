package domain.publicacion;

import domain.Mascota;
import domain.Persona;

public class PublicacionDarAdopcion extends PublicacionAdopcion {

    private Mascota mascota;

    //Constructors
    public PublicacionDarAdopcion(Persona creadoPor, Cuestionario cuestionario, Mascota mascota) {
        super(creadoPor, cuestionario);
        this.mascota = mascota;
    }

    //funcionalidad
    public void realizarAdopcion(Persona nuevoDuenio) {
       // this.mascota.setDuenio(nuevoDuenio);
    }
}
