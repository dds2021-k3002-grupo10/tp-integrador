package com.disenio.controller.usuarios;

import com.disenio.dto.usuario.UsuarioAltaDTO;
import com.disenio.dto.usuario.UsuarioDTO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.organizacion.OrganizacionService;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.usuarios.UsuarioService;
import com.disenio.services.validador.ValidadorDeClave;
import com.disenio.services.validador.criterios.impl.CriterioClaveDebil;
import com.disenio.services.validador.criterios.impl.CriterioRegex;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/usuario")

public class UsuarioController {
    private static final Logger LOGGER = Logger.getLogger(UsuarioController.class);
    ValidadorDeClave validadorDeClave = ValidadorDeClave.getInstance();
    @Autowired
    private PersonaService personaService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private OrganizacionService organizacionService;
    @Autowired
    private CriterioClaveDebil criterioClaveDebil;
    @Autowired
    private CriterioRegex criterioRegex;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> altaUsuario(HttpServletRequest request, @RequestBody UsuarioAltaDTO usuarioDTO) {
        ResponseEntity<String> response;

        try {
            // Validaciones de password
            if (!validadorDeClave.esValida(usuarioDTO.getClave())) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"description\":\"La contraseña ingresada es invalida. Ingrese otra que cumpla con los criterios \"}");
            }

            //trae Persona
            Usuario usuarioReal = new Usuario();
            usuarioReal.setNombre(usuarioDTO.getUsuario());
            usuarioReal.setClave(usuarioDTO.getClave());
            usuarioReal.setRol(usuarioReal.getRol());

            Integer idOrganizacion = (Integer) request.getSession().getAttribute("organizacion");
            Organizacion organizacion = organizacionService.getOrganizacionById(idOrganizacion);

            request.setAttribute("usuario", usuarioReal);
            //alta usuario
            organizacion.addUsuario(usuarioReal);
            usuarioService.altaUsuario(usuarioReal);
            organizacionService.alta(organizacion);

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
        Usuario rtaUsuario = usuarioService.getByNombre(usuario.getUsuario());


        if (rtaUsuario == null || !rtaUsuario.getClave().equals(usuario.getClave())) {
            response = ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"description\":\"Usuario o Contraseña invalidas. Intentelo de nuevo \"}");

        } else {

            request.getSession().setAttribute("usuario", rtaUsuario);

            response = new ResponseEntity("{" + "\"idSesion\"" + ":" + rtaUsuario.getPersona().getIdPersona() + "}", HttpStatus.OK);

        }
        return response;

    }
}
