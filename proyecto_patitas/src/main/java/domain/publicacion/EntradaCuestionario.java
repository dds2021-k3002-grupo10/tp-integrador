package domain.publicacion;

public class EntradaCuestionario {
    private String pregunta;
    private String respuesta;
    private Boolean esPreferencia;
    private Boolean esComodidad;

    //Constructors
    public EntradaCuestionario(String pregunta, String respuesta, Boolean esPreferencia, Boolean esComodidad) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.esPreferencia = esPreferencia;
        this.esComodidad = esComodidad;
    }

    public EntradaCuestionario(String pregunta, Boolean esComodidad, Boolean esPreferencia) {
        this.pregunta = pregunta;
        this.esComodidad = esComodidad;
        this.esPreferencia = esPreferencia;
        this.respuesta = "";
    }

    //Accessors

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getEsPreferencia() {
        return esPreferencia;
    }

    public void setEsPreferencia(Boolean esPreferencia) {
        this.esPreferencia = esPreferencia;
    }

    public Boolean getEsComodidad() {
        return esComodidad;
    }

    public void setEsComodidad(Boolean esComodidad) {
        this.esComodidad = esComodidad;
    }

    //Funcionalidad
    public EntradaCuestionario clonar() {
        return new EntradaCuestionario(pregunta, esComodidad, esPreferencia);
    }

    public Boolean fueRespondida() {
        return null != respuesta && !respuesta.trim().isEmpty();
    }
}
