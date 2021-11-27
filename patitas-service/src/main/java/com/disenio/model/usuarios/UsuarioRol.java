package com.disenio.model.usuarios;
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
 * UsuarioRol generated by grupo 10
 */
@Entity
@Data
@Table(name="usuario_rol",catalog="patitas")
public class UsuarioRol  implements java.io.Serializable {


    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_USUARIO_ROL", unique=true, nullable=false)
    private Integer idUsuarioRol;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_ROL", nullable=false)
    private Rol rol;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_USUARIO_ORG", nullable=false)
    private UsuarioOrganizacion usuarioOrganizacion;

    @Column(name="ESTADO", nullable=false, length=1)
    private char estado;

}


