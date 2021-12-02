package com.disenio.model.usuarios;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "rol"//, catalog = "patitas"
 )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_rol")
public abstract class Rol implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_ROL", unique = true, nullable = false)
    protected Integer idRol;

    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    protected String descripcion;

    @Column(name = "ESTADO", nullable = false, length = 1)
    protected char estado;


    //Constructor

    public Rol() {

    }

    public Rol(Integer idRol, String descripcion, char estado) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public abstract Boolean permisoDeEdicion();

    public abstract Boolean permisoAprobacion();

}
