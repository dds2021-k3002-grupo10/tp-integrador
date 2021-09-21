package com.disenio.model.organizacion.gestores;

import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.publicaciones.Publicacion;

import java.util.ArrayList;
import java.util.List;

public class GestorPublicacion {
    private Cuestionario cuestionarioDeAdopcion;
    private Cuestionario cuestionarioParaDarAdopcion;
    private List<Publicacion> publicaciones;

    /*Constructor*/
    public GestorPublicacion() {
        GestorGlobal gestor = GestorGlobal.getInstancia();
        this.cuestionarioParaDarAdopcion = gestor.getCuestionarioGlobal();
        this.publicaciones = new ArrayList<>();
    }

    /*Accessors*/

    public Cuestionario getCuestionarioDeAdopcion() {
        return cuestionarioDeAdopcion;
    }

    public void setCuestionarioDeAdopcion(Cuestionario cuestionarioDeAdopcion) {
        this.cuestionarioDeAdopcion = cuestionarioDeAdopcion;
    }

    public Cuestionario getCuestionarioParaDarAdopcion() {
        return cuestionarioParaDarAdopcion;
    }

    public void setCuestionarioParaDarAdopcion(Cuestionario cuestionarioParaDarAdopcion) {
        this.cuestionarioParaDarAdopcion = cuestionarioParaDarAdopcion;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
    /*Funcionalidad*/

    public void agregarPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }

    public void quitarPublicacion(Publicacion publicacion) {
        this.publicaciones.remove(publicacion);
    }


}
