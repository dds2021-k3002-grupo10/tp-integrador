package com.disenio.model.personas;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Calendar;
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
 * PersonaContacto generated by grupo 10
 */
@Entity
@Data
@Table(name = "persona_contacto", catalog = "patitas")
public class PersonaContacto implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_PERSONA_CONTACTO", unique = true, nullable = false)
    private Integer idPersonaContacto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MEDIO_NOTIFICACION", nullable = false)
    private MedioNotificacion medioNotificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", nullable = false)
    private Persona persona;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "APELLIDO", nullable = false, length = 50)
    private String apellido;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "TELEFONO", nullable = false)
    private int telefono;


    @Column(name = "FECHA_ALTA", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaAlta;

    @Column(name = "FECHA_ULTIMA_MODIFICACION", nullable = false, length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaUltimaModificacion;

    @Column(name = "FECHA_BAJA", length = 0)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private Calendar fechaBaja;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;

}



