package com.disenio.controller.usuarios;

import com.disenio.model.Views;
import com.disenio.model.personas.Persona;
import com.disenio.model.usuarios.Rol;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.usuarios.RolService;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
public class RolController {
    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
    @Autowired
    RolService rolService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Rol>> getRolAll() {
        ResponseEntity<List<Rol>> response;

        List<Rol> rol = null;
        if (rol.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(rol);
        }
        return response;

    }



}
