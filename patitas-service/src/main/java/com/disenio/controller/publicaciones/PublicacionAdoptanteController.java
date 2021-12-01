package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.publicacion.DTOPublicacionAdoptante;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.factory.Factory;
import com.disenio.services.publicaciones.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/publicaciones/adopciones/adoptar")
public class PublicacionAdoptanteController {


    @Autowired
    private PublicacionService publicacionService;

    @Autowired
    private Factory<PublicacionAdoptante, DTOPublicacionAdoptante> factory;

    @PostMapping(path = "/guardar")
    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionAdoptante dtoPublicacion) {
        DTOResponse dtoResponse = new DTOResponse();
        ResponseEntity<DTOResponse> response;
        PublicacionAdoptante publicacion;
        try {
            publicacion = factory.createFromDTO(dtoPublicacion);
            publicacionService.alta(publicacion);
            //TODO Agregar en la organizacion!
            dtoResponse.setStatus(HttpStatus.CREATED);
            dtoResponse.setMsg("Se creo la publicacion satisfactoriamente");
            response = new ResponseEntity(dtoResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            dtoResponse.setMsg("No se pudo crear la publicacion");
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            response = new ResponseEntity(dtoResponse, HttpStatus.NO_CONTENT);
        }

        return response;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOResponse> getPublicacionAdptanteID(@PathVariable("id") Integer id, HttpServletRequest request) {
        DTOResponse dtoResponse = new DTOResponse();

        PublicacionAdoptante publicacion = (PublicacionAdoptante) publicacionService.getById(id).orElseGet(null);
        DTOPublicacionAdoptante dtoPublicacion = new DTOPublicacionAdoptante(publicacion);
        //TODO: Se debe hacer la verificacion de la organizacion!
        dtoResponse.setStatus(HttpStatus.OK);
        dtoResponse.setData(dtoPublicacion);
        return ResponseEntity.ok(dtoResponse);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<DTOResponse> getPublicacionDarAdopcionAll() {
        DTOResponse response = new DTOResponse();
        List<PublicacionAdoptante> publicaciones = publicacionService.listarAdoptante();
        List<DTOPublicacionAdoptante> dtoPublicaciones;

        dtoPublicaciones = publicaciones.stream()
                .map(DTOPublicacionAdoptante::new)
                .collect(Collectors.toList());

        response.setStatus(HttpStatus.OK);
        response.setData(dtoPublicaciones);


        return ResponseEntity.ok(response);
    }
}

