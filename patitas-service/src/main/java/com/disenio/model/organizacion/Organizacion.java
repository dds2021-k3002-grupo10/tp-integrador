package com.disenio.model.organizacion;


import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.faq.Faq;
import com.disenio.model.usuarios.UsuarioOrganizacion;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

/**
 * Organizacion grupo 10
 */
@Entity
@Data
@Table(name = "organizacion", catalog = "patitas"
)
public class Organizacion implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_ORGANIZACION", unique = true, nullable = false)
    private Integer idOrganizacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuestionario_para_dar_adopcion_id_cuestionario")
    private Cuestionario cuestionarioByCuestionarioParaDarAdopcionIdCuestionario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuestionario_de_adopcion_id_cuestionario")
    private Cuestionario cuestionarioByCuestionarioDeAdopcionIdCuestionario;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "URL_NOMALIZADOR", nullable = false, length = 200)
    private String urlNomalizador;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacion")
    private List<UsuarioOrganizacion> usuarioOrganizacions;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacion")
    private List<Faq> faqs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacion")
    private List<NormalizaImg> normalizaImgs;



}


