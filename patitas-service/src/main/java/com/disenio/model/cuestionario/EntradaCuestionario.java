package com.disenio.model.cuestionario;

import com.disenio.model.Views;
import com.disenio.model.caracteristicas.Caracteristica;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "entrada_cuestionario"
        , catalog = "patitas"
)
public class EntradaCuestionario implements Cloneable {
    @JsonView(Views.External.class)
    private Integer idEntradaCuestionario;
    @JsonView(Views.External.class)
    private Boolean esPreferencia;
    @JsonView(Views.External.class)
    private Boolean esComodidad;
    @JsonView(Views.External.class)
    private Caracteristica caracteristica;

    //Constructors
    public EntradaCuestionario(Boolean esPreferencia, Boolean esComodidad, Caracteristica caracteristica) {
        this.esPreferencia = esPreferencia;
        this.esComodidad = esComodidad;
        this.caracteristica = caracteristica;
    }

    public EntradaCuestionario() {

    }

    //Accessors

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_ENTRADA_CUESTIONARIO", unique = true, nullable = false)
    public Integer getIdEntradaCuestionario() {
        return idEntradaCuestionario;
    }

    public void setIdEntradaCuestionario(Integer idEntradaCuestionario) {
        this.idEntradaCuestionario = idEntradaCuestionario;
    }

    @Column(name = "ES_PREFERENCIA", nullable = false)
    public Boolean getEsPreferencia() {
        return esPreferencia;
    }

    public void setEsPreferencia(Boolean esPreferencia) {
        this.esPreferencia = esPreferencia;
    }

    @Column(name = "ES_COMODIDAD", nullable = false)
    public Boolean getEsComodidad() {
        return esComodidad;
    }

    public void setEsComodidad(Boolean esComodidad) {
        this.esComodidad = esComodidad;
    }

    @OneToOne
    @JoinColumn(name = "ID_CARACTERISTICA")
    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    //Funcionalidada
    @Override
    public EntradaCuestionario clone() {
        return new EntradaCuestionario(esPreferencia, esComodidad, caracteristica);
    }
}
