package domain.publicacion;

import java.util.ArrayList;
import java.util.List;

public class Cuestionario {
    private List<EntradaCuestionario> preguntas;

    //Constructor


    public Cuestionario(List<EntradaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }

    //Accessors
    public List<EntradaCuestionario> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<EntradaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }

    //Funcionalidad
    public Cuestionario clonar() {
        List<EntradaCuestionario> preguntasClon = new ArrayList<>();

        this.preguntas
                .forEach(entradaCuestionario ->
                        preguntasClon.add(entradaCuestionario.clonar())
                );

        return new Cuestionario(preguntasClon);
    }

    public Boolean completoFormulario() {
        return this.preguntas.stream().
                allMatch(EntradaCuestionario::fueRespondida);
    }

}
