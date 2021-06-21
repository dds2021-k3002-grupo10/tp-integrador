package security.services;


import security.criterios.CriterioClaveDebil;
import security.criterios.CriterioRegex;
import security.criterios.CriterioValidacionClave;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDeClave {
    private List<CriterioValidacionClave> criteriosACumplir = new ArrayList<>();


    public void agregarCriterios() {
        CriterioRegex criterioRegex = new CriterioRegex();
        CriterioClaveDebil criterioClaveDebil = new CriterioClaveDebil();

        criteriosACumplir.add(criterioRegex);
        criteriosACumplir.add(criterioClaveDebil);
    }

    public Boolean esClaveValida(String clave){
        this.agregarCriterios();

        return criteriosACumplir.stream().allMatch(criterio -> criterio.esClaveValida(clave) == true);
    }
}
