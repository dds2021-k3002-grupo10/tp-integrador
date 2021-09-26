package com.disenio.model.organizacion.gestores;

import com.disenio.model.Views;
import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.publicaciones.Publicacion;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class GestorPublicacion {

    @JsonView(Views.External.class)
    private Cuestionario cuestionarioDeAdopcion;

    @JsonView(Views.External.class)
    private Cuestionario cuestionarioParaDarAdopcion;

    @JsonView(Views.External.class)
    private List<Publicacion> publicaciones;

    /*Constructor*/
    public GestorPublicacion() {
        GestorGlobal gestor = GestorGlobal.getInstancia();
        this.cuestionarioParaDarAdopcion = gestor.getCuestionarioGlobal();
        this.publicaciones = new ArrayList<>();
    }

    /*Accessors*/

    @OneToOne//TODO CAMBIAR
    public Cuestionario getCuestionarioDeAdopcion() {
        return cuestionarioDeAdopcion;
    }

    public void setCuestionarioDeAdopcion(Cuestionario cuestionarioDeAdopcion) {
        this.cuestionarioDeAdopcion = cuestionarioDeAdopcion;
    }

    @OneToOne//TODO CAMBIAR
    public Cuestionario getCuestionarioParaDarAdopcion() {
        return cuestionarioParaDarAdopcion;
    }

    public void setCuestionarioParaDarAdopcion(Cuestionario cuestionarioParaDarAdopcion) {
        this.cuestionarioParaDarAdopcion = cuestionarioParaDarAdopcion;
    }


    @OneToMany
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
