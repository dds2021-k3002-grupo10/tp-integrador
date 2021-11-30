package com.disenio.model.organizacion;


import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.faq.Faq;
import com.disenio.model.personas.Persona;
import com.disenio.model.usuarios.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

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
    @JoinColumn(name = "ID_CUESTIONARIO_DAR_ADOPTAR")
    private Cuestionario cuestionarioParaDarAdopcion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUESTIONARIO_DE_ADOPCION")
    private Cuestionario cuestionarioDeAdopcion;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;


    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organizacion")
    private List<Faq> faqs;

    @ManyToOne(fetch = FetchType.LAZY)
    private NormalizaImg normalizaImgs;

    //Funcionalidad
    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }
}


