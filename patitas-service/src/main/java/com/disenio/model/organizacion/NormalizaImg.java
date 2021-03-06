package com.disenio.model.organizacion;
// Generated 01/09/2021 19:13:39 by Hibernate Tools 4.3.1


import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * NormalizaImg generated by Grupo 10
 */
@Entity
@Table(name = "normaliza_img"//, catalog = "patitas"
)
public class NormalizaImg implements java.io.Serializable {


    private Integer idNormalizaImg;
    private int ancho;
    private int largo;


    public NormalizaImg() {
    }

    public NormalizaImg(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_NORMALIZA_IMG", unique = true, nullable = false)
    public Integer getIdNormalizaImg() {
        return this.idNormalizaImg;
    }

    public void setIdNormalizaImg(Integer idNormalizaImg) {
        this.idNormalizaImg = idNormalizaImg;
    }

    @Column(name = "ANCHO", nullable = false)
    public int getAncho() {
        return this.ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }


    @Column(name = "LARGO", nullable = false)
    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }


}


