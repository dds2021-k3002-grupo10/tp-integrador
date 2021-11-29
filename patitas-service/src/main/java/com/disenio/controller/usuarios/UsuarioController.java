package com.disenio.controller.usuarios;

import com.disenio.dto.persona.UsuarioDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.usuarios.Rol;
import com.disenio.model.usuarios.Usuario;
import com.disenio.model.usuarios.UsuarioOrganizacion;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.usuarios.RolService;
import com.disenio.services.usuarios.UsuarioOrganizacionService;
import com.disenio.services.usuarios.UsuarioRolService;
import com.disenio.services.usuarios.UsuarioService;
import com.disenio.services.validador.impl.CriterioClaveDebil;
import com.disenio.services.validador.impl.CriterioRegex;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/usuario")

public class UsuarioController {
    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
    @Autowired
    private PersonaService personaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioOrganizacionService usuarioOrganizacionService;
    @Autowired
    private RolService rolService;
    @Autowired
    private UsuarioRolService usuarioRolService;
    @Autowired
    private CriterioClaveDebil criterioClaveDebil;
    @Autowired
    private CriterioRegex criterioRegex;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> altaUsuario(HttpServletRequest request, @RequestBody Usuario usuario) {
        ResponseEntity response;
        try {
            // Validaciones de password
            ResponseEntity<String> isNotValid = validatePass(usuario.getClave());
            if (isNotValid != null) return isNotValid;

            //trae Persona
            Optional<Persona> persona = personaService.getPersonasById(usuario.getPersona().getIdPersona());


            //alta usuario
            usuario.setPersona(persona.get());

            usuarioService.altaUsuario(usuario);

            response = new ResponseEntity(HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            response = new ResponseEntity(e, HttpStatus.BAD_REQUEST);
            LOGGER.error("Ocurrio un error al dar de Alta", e);
        }
        return response;
    }


    @PostMapping(value = "/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody UsuarioDTO usuario) {
        ResponseEntity response;
        System.out.println("RECIBI:" + usuario.getUsuario() + usuario.getClave());
        Usuario rtaUsuario = usuarioService.getByNombre(usuario.getUsuario());
        System.out.println(rtaUsuario == null);
        if (rtaUsuario == null || !rtaUsuario.getClave().equals(usuario.getClave())) {
            response = ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"description\":\"El password no cumple los requisitos del TP \"}");
            System.out.println("Se logueo fallo");
        } else {
            System.out.println("Se logueo ok");
            request.getSession().setAttribute("usuario", rtaUsuario);

            response = new ResponseEntity("{" + "\"idSesion\"" + ":" + rtaUsuario.getPersona().getIdPersona() + "}", HttpStatus.OK);

        }
        return response;

    }

    @RequestMapping(value = "/rol", method = RequestMethod.POST)
    public ResponseEntity<String> altaUsuarioRol(HttpServletRequest request, @RequestBody UsuarioOrganizacion usuarioOrganizacion) {
        ResponseEntity response;
        try {

            //trae UsuarioOrganizacion
            UsuarioOrganizacion rtaUsuarioOrganizacion = usuarioOrganizacionService.getByIdUsuarioAndIdOrganizacion(usuarioOrganizacion.getUsuario().getIdUsuario(), usuarioOrganizacion.getOrganizacion().getIdOrganizacion());

            //trae rol
            Rol rtaRol = rolService.getById(usuarioOrganizacion.getUsuarioRols().get(0).getRol().getIdRol());

            //alta usuarioRol
            usuarioRolService.alta(rtaRol, rtaUsuarioOrganizacion);

            response = new ResponseEntity(HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            response = new ResponseEntity(e, HttpStatus.BAD_REQUEST);
            LOGGER.error("Ocurrio un error al dar de Alta", e);
        }
        return response;
    }


    @Nullable
    private ResponseEntity<String> validatePass(@NotNull String clave) {

        if (clave.isEmpty()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"description\":\"El password no cumple los requisitos del TP \"}");
        }
        if (!criterioClaveDebil.esClaveValida(clave) || !criterioRegex.esClaveValida(clave)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"description\":\"El password no cumple los requisitos del TP \"}");
        }
        return null;
    }
}
