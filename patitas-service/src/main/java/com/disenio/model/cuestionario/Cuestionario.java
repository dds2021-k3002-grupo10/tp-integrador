package com.disenio.model.cuestionario;

import com.disenio.model.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cuestionario"
        , catalog = "patitas"
)
public class Cuestionario implements Cloneable {

    @JsonView(Views.External.class)
    private Integer idCuestionario;

    @JsonView(Views.External.class)
    private List<EntradaCuestionario> preguntas;

    //Constructors
    public Cuestionario() {
        this.preguntas = new ArrayList<>();
    }

    public Cuestionario(List<EntradaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }

    //Accessors
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CUESTIONARIO", unique = true, nullable = false)
    public Integer getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    @OneToMany
    public List<EntradaCuestionario> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<EntradaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public Cuestionario clone() {
        List<EntradaCuestionario> cuestionario = preguntas.stream().map(entradaCuestionario -> entradaCuestionario.clone()).collect(Collectors.toList());
        return (Cuestionario) new Cuestionario(preguntas);
    }
}
