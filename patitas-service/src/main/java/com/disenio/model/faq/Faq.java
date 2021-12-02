package com.disenio.model.faq;


import com.disenio.model.organizacion.Organizacion;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Faq generated grupo10
 */
@Entity
@Data
@Table(name = "faq"//, catalog = "patitas"
)
public class Faq implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_FAQ", unique = true, nullable = false)
    private Integer idFaq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPORTAMIENTO_TIPO", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FaqComportamientoTipo faqComportamientoTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PREGUNTA_TIPO")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FaqPreguntaTipo faqPreguntaTipo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ORGANIZACION", nullable = false)
    private Organizacion organizacion;

    @Column(name = "DESCRIPCION_FAQ", nullable = false, length = 2000)
    private String descripcionFaq;

    @Column(name = "ESTADO", length = 1)
    private String estado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_ALTA", nullable = false, length = 10)
    private Date fechaAlta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_BAJA", length = 10)
    private Date fechaBaja;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 10)
    private Date fechaUltimaModificacion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<FaqRespuestaValor> faqRespuestaValors;

    //Funcionalidad
    public void addFaqRespuesta(FaqRespuestaValor faqRespuestaValor) {
        this.faqRespuestaValors.add(faqRespuestaValor);
    }
}


