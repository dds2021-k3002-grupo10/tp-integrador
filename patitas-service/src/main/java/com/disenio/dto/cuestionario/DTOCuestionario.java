package com.disenio.dto.cuestionario;

import com.disenio.model.cuestionario.Cuestionario;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
import java.util.stream.Collectors;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DTOCuestionario {
    Integer idCuestionario;
    List<DTOEntradaCuestionario> entradaCuestionario;

    public DTOCuestionario(Integer idCuestionario, List<DTOEntradaCuestionario> entradaCuestionario) {
        this.idCuestionario = idCuestionario;
        this.entradaCuestionario = entradaCuestionario;
    }

    public DTOCuestionario(Cuestionario cuestionario) {
        this.idCuestionario = cuestionario.getIdCuestionario();
        this.entradaCuestionario = cuestionario.getPreguntas().stream()
                .map(DTOEntradaCuestionario::new)
                .collect(Collectors.toList());
    }

    public Integer getIdCuestionario() {
        return idCuestionario;
    }

    public void setIdCuestionario(Integer idCuestionario) {
        this.idCuestionario = idCuestionario;
    }

    public List<DTOEntradaCuestionario> getEntradaCuestionario() {
        return entradaCuestionario;
    }

    public void setEntradaCuestionario(List<DTOEntradaCuestionario> entradaCuestionario) {
        this.entradaCuestionario = entradaCuestionario;
    }
}
