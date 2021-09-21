package com.disenio.model.organizacion.gestores;

import com.disenio.model.cuestionario.Cuestionario;

public class GestorGlobal {
    private static GestorGlobal instancia = null;
    private Cuestionario cuestionarioGlobal;

    /*Constructor*/
    private GestorGlobal() {
    }

    /*Accessors*/

    public static GestorGlobal getInstancia() {
        if (instancia == null) {
            instancia = new GestorGlobal();
        }
        return instancia;
    }

    public Cuestionario getCuestionarioGlobal() {
        return cuestionarioGlobal.clone();
    }

    public void setCuestionarioGlobal(Cuestionario cuestionarioGlobal) {
        this.cuestionarioGlobal = cuestionarioGlobal;
    }

}
