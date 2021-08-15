package domain.publicacion;

import domain.Persona;

public class PublicacionAdoptante extends PublicacionAdopcion {
    private Persona adoptante;
    private Boolean esVisible;

//Constructors

    public PublicacionAdoptante(Persona creadoPor, Cuestionario cuestionario, Persona adoptante, Boolean esVisible) {
        super(creadoPor, cuestionario);
        this.adoptante = adoptante;
        this.esVisible = esVisible;
    }

    //Accessors

    public Boolean getEsVisible() {
        return esVisible;
    }

    public void setEsVisible(Boolean esVisible) {
        this.esVisible = esVisible;
    }

    public Persona getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Persona adoptante) {
        this.adoptante = adoptante;
    }

    //Funcionalidad
    public void darDeBaja() {
        this.esVisible = false;
    }

    public String generarLink() {
        //TODO: Link base del dominio <- Potencial archivo Config
        String base = "https://dominio.com/ruta/baja/";
        base += getId();
        return base;
    }
    /*Todo: Dar de baja + links*/
}
