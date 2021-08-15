package com.disenio.model.caracteristicas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Valor generated by hbm2java
 */
@Entity
@Data
@Table(name = "valor"
        , catalog = "patitas"
)
public class Valor implements java.io.Serializable {
    @JsonView(Views.External.class)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_VALOR", unique = true, nullable = false)
    private Integer idValor;
    @JsonView(Views.External.class)
    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;

}

