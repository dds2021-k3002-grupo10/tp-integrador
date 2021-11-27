package com.disenio.model.mascotas;

import com.disenio.model.faq.Faq;
import com.fasterxml.jackson.annotation.JsonFormat;
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

/**
 * CaracteristicaDetalle grupo 10
 */
@Entity
@Data
@Table(name="caracteristica_detalle"
    ,catalog="patitas"
)
public class CaracteristicaDetalle  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_DETALLE", unique=true, nullable=false)
     private Integer idDetalle;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_FAQ", nullable=false)
     private Faq faq;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_MASCOTA", nullable=false)
     private Mascota mascota;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name="FECHA_ALTA", nullable=false, length=10)
     private Date fechaAlta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name="FECHA_ULTIMA_MODIFICACION", nullable=false, length=10)
     private Date fechaUltimaModificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name="FECHA_BAJA", length=10)
     private Date fechaBaja;

    @Column(name="ESTADO", nullable=false, length=1)
     private char estado;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="caracteristicaDetalle")
     private List<CaracteristicaDetalleValor> caracteristicaDetalleValors;


}

