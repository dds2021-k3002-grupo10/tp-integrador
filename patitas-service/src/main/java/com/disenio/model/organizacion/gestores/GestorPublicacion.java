package com.disenio.model.organizacion.gestores;

import javax.persistence.Embeddable;

@Embeddable
public class GestorPublicacion {

   /* @JsonView(Views.External.class)
    private Cuestionario cuestionarioDeAdopcion;

    @JsonView(Views.External.class)
    private Cuestionario cuestionarioParaDarAdopcion;

    @JsonView(Views.External.class)
    private List<Publicacion> publicaciones;

    public GestorPublicacion() {
        GestorGlobal gestor = GestorGlobal.getInstancia();
        this.cuestionarioParaDarAdopcion = gestor.getCuestionarioGlobal();
        this.publicaciones = new ArrayList<>();
    }


    @OneToOne
    public Cuestionario getCuestionarioDeAdopcion() {
        return cuestionarioDeAdopcion;
    }

    public void setCuestionarioDeAdopcion(Cuestionario cuestionarioDeAdopcion) {
        this.cuestionarioDeAdopcion = cuestionarioDeAdopcion;
    }

    @OneToOne
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



    public void agregarPublicacion(Publicacion publicacion) {
        this.publicaciones.add(publicacion);
    }

    public void quitarPublicacion(Publicacion publicacion) {
        this.publicaciones.remove(publicacion);
    }
*/

}

