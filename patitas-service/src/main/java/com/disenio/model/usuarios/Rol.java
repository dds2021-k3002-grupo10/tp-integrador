package com.disenio.model.usuarios;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

@Entity
@Data
@Table(name = "rol", catalog = "patitas")
public class Rol implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_ROL", unique = true, nullable = false)
    private Integer idRol;

    @Column(name = "DESCRIPCION", nullable = false, length = 20)
    private String descripcion;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<UsuarioRol> usuarioRols;


}
