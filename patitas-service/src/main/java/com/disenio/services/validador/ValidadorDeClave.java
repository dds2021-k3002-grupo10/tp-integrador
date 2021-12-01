package com.disenio.services.validador;

import com.disenio.services.validador.criterios.CriterioValidacionClave;
import com.disenio.services.validador.criterios.impl.CriterioClaveDebil;
import com.disenio.services.validador.criterios.impl.CriterioRegex;

import java.util.Arrays;
import java.util.List;

public class ValidadorDeClave {
    static ValidadorDeClave instance = null;
    private List<CriterioValidacionClave> criterios;

    public ValidadorDeClave() {
        this.criterios = Arrays.asList(new CriterioRegex(), new CriterioClaveDebil());
    }

    //GettersAndSetters
    public static ValidadorDeClave getInstance() {
        if (instance == null) {
            instance = new ValidadorDeClave();
        }
        return instance;
    }

    public List<CriterioValidacionClave> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<CriterioValidacionClave> criterios) {
        this.criterios = criterios;
    }

    //Funcionalidad
    public void addCriterio(CriterioValidacionClave criterioValidacionClave) {
        this.criterios.add(criterioValidacionClave);
    }

    public void removeCriterio(CriterioValidacionClave criterioValidacionClave) {
        this.criterios.remove(criterioValidacionClave);
    }

    public Boolean esValida(String clave) {
        return this.criterios.stream().allMatch(criterio -> criterio.esClaveValida(clave));
    }
}
