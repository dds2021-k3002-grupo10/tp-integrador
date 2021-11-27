package com.disenio.model.mascotas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.disenio.model.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * SexoMascota generated by Grupo 10
 */
@Entity
@Data
@Table(name = "sexo_mascota", catalog = "patitas")
public class SexoMascota implements java.io.Serializable {

    @Id
    @JsonView(Views.External.class)
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_SEXO", unique = true, nullable = false)
    private Integer idSexo;

    @JsonView(Views.External.class)
    @Column(name = "DESCRIPCION", nullable = false, length = 10)
    private String descripcion;
/*
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sexoMascota")
    private List<Mascota> mascotas;
*/
}


