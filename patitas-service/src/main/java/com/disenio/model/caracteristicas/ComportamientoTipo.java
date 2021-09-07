package com.disenio.model.caracteristicas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComportamientoTipo generated by hbm2java
 */
@Entity
@Data
@Table(name = "comportamiento_tipo"
        , catalog = "patitas"
)
public class ComportamientoTipo implements java.io.Serializable {

    @JsonView(Views.External.class)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_COMPORTAMIENTO_TIPO", unique = true, nullable = false)
    private Integer idComportamientoTipo;
    @JsonView(Views.External.class)
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;
    @JsonView(Views.Internal.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comportamientoTipo")
    private List<Caracteristica> caracteristicas;


}


