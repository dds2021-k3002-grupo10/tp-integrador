package com.disenio.model.caracteristicas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.mascotas.Mascota;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

/**
 * CaracteristicaDetalle generated by hbm2java
 */
@Entity
@Data
@Table(name = "caracteristica_detalle"
        , catalog = "patitas"
)
public class CaracteristicaDetalle implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_DETALLE", unique = true, nullable = false)
    private Integer idDetalle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARACTERISTICA", nullable = false)
    private CaracteristicaDetalleValor caracteristicaDetalleValor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MASCOTA", nullable = false)
    private Mascota mascota;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    private Date fechaAlta;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    private Date fechaUltimaModificacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_BAJA", length = 0)
    private Date fechaBaja;
    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "caracteristicaDetalle")
    private List<CaracteristicaDetalleValor> caracteristicaDetalleValors;

}

