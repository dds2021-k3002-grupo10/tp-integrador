package com.disenio.dto.mascota;

import com.disenio.model.mascotas.CaracteristicaDetalle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DTOMascotaCaracteristica {
    private int idPregunta;
    private String pregunta;
    private List<String> respuestas;


    public DTOMascotaCaracteristica(int idPregunta, String pregunta, List<String> respuestas) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public DTOMascotaCaracteristica(CaracteristicaDetalle caracteristicaDetalle) {
        this.idPregunta = caracteristicaDetalle.getFaq().getIdFaq();
        this.pregunta = caracteristicaDetalle.getFaq().getDescripcionFaq();
        if (!caracteristicaDetalle.getCaracteristicaDetalleValors().isEmpty()) {
            this.respuestas = caracteristicaDetalle.getCaracteristicaDetalleValors().stream().map(caracteristicaDetalleValor -> caracteristicaDetalleValor.getFaqRespuestaValor().getDescripcion()).collect(Collectors.toList());
        } else {
            this.respuestas = new ArrayList<>();
        }
    }


    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<String> respuestas) {
        this.respuestas = respuestas;
    }
}
