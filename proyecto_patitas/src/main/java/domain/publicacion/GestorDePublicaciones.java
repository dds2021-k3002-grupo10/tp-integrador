package domain.publicacion;

import java.util.ArrayList;
import java.util.List;

public class GestorDePublicaciones {
    private Cuestionario cuestionarioBasicoDeAdopcion;
    private Cuestionario cuestionarioOrganizacionDeAdopcion;
    private Cuestionario cuestionarioParaDarDeAdopcion;
    private List<Publicacion> publicaciones;

    //Constructor
    public GestorDePublicaciones(Cuestionario cuestionarioBasicoDeAdopcion, Cuestionario cuestionarioOrganizacionDeAdopcion, Cuestionario cuestionarioParaDarDeAdopcion) {
        this.cuestionarioBasicoDeAdopcion = cuestionarioBasicoDeAdopcion;
        this.cuestionarioOrganizacionDeAdopcion = cuestionarioOrganizacionDeAdopcion;
        this.cuestionarioParaDarDeAdopcion = cuestionarioParaDarDeAdopcion;
        this.publicaciones = new ArrayList<>();
    }

    //Accessors
    public Cuestionario getCuestionarioBasicoDeAdopcion() {
        return cuestionarioBasicoDeAdopcion;
    }

    public void setCuestionarioBasicoDeAdopcion(Cuestionario cuestionarioBasicoDeAdopcion) {
        this.cuestionarioBasicoDeAdopcion = cuestionarioBasicoDeAdopcion;
    }

    public Cuestionario getCuestionarioOrganizacionDeAdopcion() {
        return cuestionarioOrganizacionDeAdopcion;
    }

    public void setCuestionarioOrganizacionDeAdopcion(Cuestionario cuestionarioOrganizacionDeAdopcion) {
        this.cuestionarioOrganizacionDeAdopcion = cuestionarioOrganizacionDeAdopcion;
    }

    public Cuestionario getCuestionarioParaDarDeAdopcion() {
        return cuestionarioParaDarDeAdopcion;
    }

    public void setCuestionarioParaDarDeAdopcion(Cuestionario cuestionarioParaDarDeAdopcion) {
        this.cuestionarioParaDarDeAdopcion = cuestionarioParaDarDeAdopcion;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    //Funcionalidad
    public void agregarPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }

    public void quitarPublicacion(Publicacion publicacion) {
        this.publicaciones.remove(publicacion);
    }

}
