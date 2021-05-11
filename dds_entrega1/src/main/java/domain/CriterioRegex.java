package domain;

import edu.vt.middleware.password.*;

import java.util.ArrayList;
import java.util.List;

public class CriterioRegex implements CriterioValidacionClave{

    List<Rule> listaDeReglas = new ArrayList<Rule>();

    public void criteriosRegex(){
        LengthRule longitud = new LengthRule(8,64);
        UppercaseCharacterRule mayuscula = new UppercaseCharacterRule();
        DigitCharacterRule numero = new DigitCharacterRule();


        this.listaDeReglas.add(longitud);
        this.listaDeReglas.add(mayuscula);
        this.listaDeReglas.add(numero);

    }

    public Boolean esClaveValida(String clave){

        this.criteriosRegex();

        PasswordValidator validador = new PasswordValidator(this.listaDeReglas);

        PasswordData claveAVerificar = new PasswordData(new Password(clave));

        RuleResult verificar = validador.validate(claveAVerificar);

        return verificar.isValid();
    }
}

