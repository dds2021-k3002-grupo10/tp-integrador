package com.disenio.dto.cuestionario;

import com.disenio.model.cuestionario.EntradaCuestionario;
import com.disenio.model.faq.Faq;
import com.disenio.model.faq.FaqRespuestaValor;

import java.util.List;
import java.util.stream.Collectors;

public class DTOEntradaCuestionario {
    private Integer idEntradaCuestionario;
    private String tipoPregunta;
    private String pregunta;
    private List<String> respuesta;

    public DTOEntradaCuestionario(Integer idEntradaCuestionario, String tipoPregunta, String pregunta, List<String> respuesta) {
        this.idEntradaCuestionario = idEntradaCuestionario;
        this.tipoPregunta = tipoPregunta;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public DTOEntradaCuestionario(EntradaCuestionario entradaCuestionario) {
        Faq faq = entradaCuestionario.getFaq();
        this.idEntradaCuestionario = entradaCuestionario.getIdEntradaCuestionario();
        this.pregunta = faq.getDescripcionFaq();
        this.tipoPregunta = faq.getFaqPreguntaTipo().getDescripcionFaq();
        this.respuesta = entradaCuestionario.getRespuesta().stream()
                .map(FaqRespuestaValor::getDescripcion)
                .collect(Collectors.toList());
    }

    public Integer getIdEntradaCuestionario() {
        return idEntradaCuestionario;
    }

    public void setIdEntradaCuestionario(Integer idEntradaCuestionario) {
        this.idEntradaCuestionario = idEntradaCuestionario;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<String> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(List<String> respuesta) {
        this.respuesta = respuesta;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }
}
