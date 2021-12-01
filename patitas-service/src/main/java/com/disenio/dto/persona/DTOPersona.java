package com.disenio.dto.persona;

import com.disenio.model.personas.Persona;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DTOPersona implements Serializable {

    List<ContactosAltaDTO> contactos;
    private Integer idPersona;
    private String nombre;
    private String apellido;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+8")
    private String fechaNacimiento;
    private char estado;
    private PersonaDocumentoDTO personaDocumentos;
    private PersonaDireccionDTO personaDireccions;

    //Constructor Persona
    public DTOPersona(Integer idPersona, String nombre, String apellido) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public DTOPersona(Persona persona) {
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

    public List<ContactosAltaDTO> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactosAltaDTO> contactos) {
        this.contactos = contactos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public PersonaDocumentoDTO getPersonaDocumentos() {
        return personaDocumentos;
    }

    public void setPersonaDocumentos(PersonaDocumentoDTO personaDocumentos) {
        this.personaDocumentos = personaDocumentos;
    }

    public PersonaDireccionDTO getPersonaDireccions() {
        return personaDireccions;
    }

    public void setPersonaDireccions(PersonaDireccionDTO personaDireccions) {
        this.personaDireccions = personaDireccions;
    }
}
