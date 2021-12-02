package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.Publicacion;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.publicaciones.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/publicaciones")
public class PublicacionController {
    @Autowired
    private PublicacionService publicacionService;

    @GetMapping(path = "/notificar/{id}")
    public ResponseEntity<DTOResponse> getPublicacionesPerdidasByID(@PathVariable("id") Integer id, HttpServletRequest request) {
        DTOResponse dtoResponse = new DTOResponse();
        ResponseEntity<DTOResponse> response;
        try {
            Optional<Publicacion> publicacion = publicacionService.getById(id);
            if (!publicacion.isPresent()) {
                dtoResponse.setMsg("No existe la publicacion");
            }
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            if (usuario == null) {
                dtoResponse.setMsg("Debe estar logueado");
            }
            Persona persona = usuario.getPersona();
            Persona autor = publicacion.get().getAutor();
            if (persona == null) {
                dtoResponse.setMsg("Este usuario no tiene persona!");
            }
            dtoResponse.setMsg("Se notifica!");
            System.out.println("Te contamos que " + persona.getNombre() + "Te quiere contactar por tu publicacion " + id);
            autor.notificar("Te contamos que " + persona.getNombre() + "Te quiere contactar por tu publicacion " + id);
        } catch (Exception e) {
            e.printStackTrace();
            dtoResponse.setData(HttpStatus.FORBIDDEN);
        }

        return ResponseEntity.ok(dtoResponse);
    }
}
