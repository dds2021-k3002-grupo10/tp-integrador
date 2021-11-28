package com.disenio.services.validador.impl;

import com.disenio.services.validador.ValidacionClaveService;
import org.passay.AllowedRegexRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriterioRegex implements ValidacionClaveService {

    //@Autowired
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
