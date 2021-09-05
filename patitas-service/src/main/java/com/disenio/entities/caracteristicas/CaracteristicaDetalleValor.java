package com.disenio.entities.caracteristicas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
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

/**
 * CaracteristicaDetalleValor generated by hbm2java
 */
@Entity
@Table(name="caracteristica_detalle_valor"
    ,catalog="patitas"
)
public class CaracteristicaDetalleValor  implements java.io.Serializable {


     private Integer idDetalleValor;
     private CaracteristicaDetalle caracteristicaDetalle;
     private Valor valor;
     private char estado;
     private Set<CaracteristicaDetalle> caracteristicaDetalles = new HashSet(0);

    public CaracteristicaDetalleValor() {
    }

	
    public CaracteristicaDetalleValor(CaracteristicaDetalle caracteristicaDetalle, Valor valor, char estado) {
        this.caracteristicaDetalle = caracteristicaDetalle;
        this.valor = valor;
        this.estado = estado;
    }
    public CaracteristicaDetalleValor(CaracteristicaDetalle caracteristicaDetalle, Valor valor, char estado, Set caracteristicaDetalles) {
       this.caracteristicaDetalle = caracteristicaDetalle;
       this.valor = valor;
       this.estado = estado;
       this.caracteristicaDetalles = caracteristicaDetalles;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID_DETALLE_VALOR", unique=true, nullable=false)
    public Integer getIdDetalleValor() {
        return this.idDetalleValor;
    }
    
    public void setIdDetalleValor(Integer idDetalleValor) {
        this.idDetalleValor = idDetalleValor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_DETALLE", nullable=false)
    public CaracteristicaDetalle getCaracteristicaDetalle() {
        return this.caracteristicaDetalle;
    }
    
    public void setCaracteristicaDetalle(CaracteristicaDetalle caracteristicaDetalle) {
        this.caracteristicaDetalle = caracteristicaDetalle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_VALOR", nullable=false)
    public Valor getValor() {
        return this.valor;
    }
    
    public void setValor(Valor valor) {
        this.valor = valor;
    }

    
    @Column(name="ESTADO", nullable=false, length=1)
    public char getEstado() {
        return this.estado;
    }
    
    public void setEstado(char estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="caracteristicaDetalleValor")
    public Set<CaracteristicaDetalle> getCaracteristicaDetalles() {
        return this.caracteristicaDetalles;
    }
    
    public void setCaracteristicaDetalles(Set caracteristicaDetalles) {
        this.caracteristicaDetalles = caracteristicaDetalles;
    }




}

