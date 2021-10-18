package com.disenio.model.usuarios;

import com.disenio.model.organizacion.Organizacion;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "usuario_organizacion", catalog = "patitas")
public class UsuarioOrganizacion implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_USUARIO_ORG", unique = true, nullable = false)
    private Integer idUsuarioOrg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORGANIZACION", nullable = false)
    private Organizacion organizacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioOrganizacion")
    private List<UsuarioRol> usuarioRols;

}


