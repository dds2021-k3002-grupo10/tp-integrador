package com.disenio.services.cuestionarios;

import com.disenio.model.cuestionario.Cuestionario;

import java.util.List;

public interface CuestionarioService {
    Cuestionario getById(Integer id);

    List<Cuestionario> getCuestionarioAll();

    void alta(Cuestionario c);
}
