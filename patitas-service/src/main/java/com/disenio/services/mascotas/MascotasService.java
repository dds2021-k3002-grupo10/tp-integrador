package com.disenio.services.mascotas;

import com.disenio.model.mascotas.Mascota;
import com.disenio.model.personas.Persona;

import java.util.List;

public interface MascotasService {

    void alta(List<Mascota> mascotas, Persona persona);
}
