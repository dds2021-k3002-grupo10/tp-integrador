package com.disenio.services.validador.criterios.impl;

import com.disenio.services.validador.criterios.CriterioValidacionClave;
import org.passay.AllowedRegexRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.springframework.stereotype.Service;

@Service
public class CriterioRegex implements CriterioValidacionClave {

    //Expresión regular que me permite verificar que una contraseña tiene una minúscula, una mayúscula, un número y más de 8 caracteres.
    private String criterioRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,64}$";

    public Boolean esClaveValida(String clave){
        AllowedRegexRule validadorRegex = new AllowedRegexRule(criterioRegex);

        PasswordValidator validador = new PasswordValidator(validadorRegex);
        PasswordData contrasena = new PasswordData(clave);
        RuleResult esValida = validador.validate(contrasena);

        return esValida.isValid();

    }
}
