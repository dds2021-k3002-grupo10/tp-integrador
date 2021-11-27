package com.disenio.model.personas;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MedioNotificacion generated by grupo 10
 */
@Entity
@Data
@Table(name="medio_notificacion" ,catalog="patitas"
)
public class MedioNotificacion  implements java.io.Serializable {

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="ID_MEDIO_NOTIFICACION", unique=true, nullable=false)
    private Integer idMedioNotificacion;

    @Column(name="DESCRIPCION", nullable=false, length=50)
    private String descripcion;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy="medioNotificacion")
    private Set<PersonaContacto> personaContactos;

}


