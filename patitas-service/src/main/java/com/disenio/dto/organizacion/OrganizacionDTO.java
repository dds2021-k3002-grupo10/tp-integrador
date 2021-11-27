package com.disenio.dto.organizacion;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class OrganizacionDTO {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_ORGANIZACION", unique = true, nullable = false)
    private Integer idOrganizacion;

    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;

    @Column(name = "URL_NOMALIZADOR", nullable = false, length = 200)
    private String urlNomalizador;

    @Column(name = "ESTADO", nullable = false, length = 1)
    private char estado;
}
