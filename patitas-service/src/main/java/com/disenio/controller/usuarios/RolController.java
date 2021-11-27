package com.disenio.controller.usuarios;

import com.disenio.model.usuarios.Rol;
import com.disenio.services.usuarios.RolService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
