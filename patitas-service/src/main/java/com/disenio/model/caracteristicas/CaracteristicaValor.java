package com.disenio.model.caracteristicas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CaracteristicaValor generated by hbm2java
 */
@Entity
@Data
@Table(name = "caracteristica_valor"
        , catalog = "patitas"
)
public class CaracteristicaValor implements java.io.Serializable {
    @JsonView(Views.External.class)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CARACTERISTICA_VALOR", unique = true, nullable = false)
    private Integer idCaracteristicaValor;
    @JsonView(Views.Internal.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARACTERISTICA", nullable = false)
    private Caracteristica caracteristica;
    @JsonView(Views.External.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VALOR", nullable = false)
    private Valor valor;

}

