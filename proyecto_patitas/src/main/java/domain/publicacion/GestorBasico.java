package domain.publicacion;

public class GestorBasico {
    //...
    private static GestorBasico instancia = null;
    private Cuestionario cuestionarioBasico;

    public GestorBasico getInstancia() {
        if (instancia == null) {
            instancia = new GestorBasico();
        }
        return instancia;
    }

    public void setCuestionarioBasico(Cuestionario cuestionarioBasico) {
        this.cuestionarioBasico = cuestionarioBasico;
    }

    public Cuestionario getCuestionarioBasico() {
        return cuestionarioBasico;
    }
}
