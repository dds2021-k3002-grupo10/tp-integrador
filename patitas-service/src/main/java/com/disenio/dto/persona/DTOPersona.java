package com.disenio.dto.persona;

import com.disenio.model.Views;
import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;

@Data
public class DTOPersona implements Serializable {
    @JsonView(Views.External.class)
    Integer idPersona;
    @JsonView(Views.External.class)
    String nombre;
    @JsonView(Views.External.class)
    String apellido;

    //Constructor Persona
    public DTOPersona(Integer idPersona, String nombre, String apellido) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public DTOPersona(Persona persona){
        this.idPersona = persona.getIdPersona();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
    }
    //Getters and Setters
    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
