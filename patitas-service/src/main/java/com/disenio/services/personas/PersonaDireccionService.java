package com.disenio.services.personas;

import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDireccion;

import java.util.List;

public interface PersonaDireccionService {
    void alta(List<PersonaDireccion> personaDireccions, Persona persona);
}
