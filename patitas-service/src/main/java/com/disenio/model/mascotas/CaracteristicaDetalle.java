package com.disenio.model.mascotas;

import com.disenio.model.faq.Faq;
import com.disenio.model.faq.FaqRespuestaValor;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * CaracteristicaDetalle grupo 10
 */
@Entity
@Data
@Table(name = "caracteristica_detalle"
     //   , catalog = "patitas"
)
public class CaracteristicaDetalle implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_DETALLE", unique = true, nullable = false)
    private Integer idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FAQ", nullable = false)
    private Faq faq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MASCOTA", nullable = false)
    private Mascota mascota;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_ALTA", nullable = false, length = 10)
    private Date fechaAlta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 10)
    private Date fechaUltimaModificacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    @Column(name = "FECHA_BAJA", length = 10)
    private Date fechaBaja;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FaqRespuestaValor> faqRespuestaValor;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Faq getFaq() {
        return faq;
    }

    public void setFaq(Faq faq) {
        this.faq = faq;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public List<FaqRespuestaValor> getFaqRespuestaValor() {
        return faqRespuestaValor;
    }

    public void setFaqRespuestaValor(List<FaqRespuestaValor> faqRespuestaValor) {
        this.faqRespuestaValor = faqRespuestaValor;
    }
}


