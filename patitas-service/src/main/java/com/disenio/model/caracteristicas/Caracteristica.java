package com.disenio.model.caracteristicas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.disenio.model.organizacion.Organizacion;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Data
@Table(name = "caracteristica"
        , catalog = "patitas"
)
public class Caracteristica implements java.io.Serializable {

    @JsonView(Views.External.class)
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CARACTERISTICA", unique = true, nullable = false)
    private Integer idCaracteristica;

    @JsonView(Views.External.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPORTAMIENTO_TIPO", nullable = false)
    private ComportamientoTipo comportamientoTipo;

    @JsonView(Views.External.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORGANIZACION", nullable = false)
    private Organizacion organizacion;

    @JsonView(Views.External.class)
    @Column(name = "DESCRIPCION_FAQ", nullable = false, length = 100)
    private String descripcionFaq;

    @JsonView(Views.External.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    private Date fechaAlta;

    @JsonView(Views.External.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    private Date fechaUltimaModificacion;

    @JsonView(Views.External.class)
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BAJA", length = 0)
    private Date fechaBaja;

    @JsonView(Views.External.class)
    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @JsonView(Views.External.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "caracteristica")
    private List<CaracteristicaValor> caracteristicaValors;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="caracteristica")
    private List<CaracteristicaDetalle> caracteristicaDetalles;


}


