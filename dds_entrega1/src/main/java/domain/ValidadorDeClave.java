package domain;

public class ValidadorDeClave {

    public Boolean esClaveValida(String claveNueva){

        CriterioClaveDebil claveDebil = new CriterioClaveDebil();
        CriterioRegex criterioRegex = new CriterioRegex();

        Boolean esClaveFuerte = claveDebil.esClaveValida(claveNueva);
        Boolean cumpleRequisitos = criterioRegex.esClaveValida(claveNueva);

        return esClaveFuerte && cumpleRequisitos;
    }

}
