package com.disenio.services.builder.impl;

import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.model.personas.PersonaDireccion;
import com.disenio.model.personas.PersonaDocumento;
import com.disenio.services.builder.Builder;

import java.util.Calendar;
import java.util.List;

public class BuilderPersona implements Builder<Persona> {

    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;
    private Calendar fechaAlta;
    private Calendar fechaUltimaModificacion;
    private Calendar fechaBaja;
    private char estado;
    private PersonaDocumento personaDocumentos;
    private List<PersonaContacto> personaContactos;
    private PersonaDireccion personaDireccions;
    private List<Mascota> mascotas;

    public BuilderPersona setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public BuilderPersona setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public BuilderPersona setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public BuilderPersona setFechaAlta(Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public BuilderPersona setFechaUltimaModificacion(Calendar fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        return this;
    }

    public BuilderPersona setFechaBaja(Calendar fechaBaja) {
        this.fechaBaja = fechaBaja;
        return this;
    }

    public BuilderPersona setEstado(char estado) {
        this.estado = estado;
        return this;
    }

    public BuilderPersona setPersonaDocumentos(PersonaDocumento personaDocumentos) {
        this.personaDocumentos = personaDocumentos;
        return this;
    }

    public BuilderPersona setPersonaContactos(List<PersonaContacto> personaContactos) {
        this.personaContactos = personaContactos;
        return this;
    }

    public BuilderPersona setPersonaDireccions(PersonaDireccion personaDireccions) {
        this.personaDireccions = personaDireccions;
        return this;
    }

    public BuilderPersona setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
        return this;
    }

    @Override
    public Persona create() {

        return new Persona(nombre, apellido, fechaNacimiento, fechaAlta, fechaUltimaModificacion, fechaBaja, estado, personaDocumentos, personaContactos, personaDireccions, mascotas);
    }
}
