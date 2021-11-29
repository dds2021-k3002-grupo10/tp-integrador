package com.disenio.controller.publicaciones;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.mascota.DTOMascotaPerdida;
import com.disenio.dto.mascota.DTOUbicacionMascota;
import com.disenio.dto.persona.DTOPersona;
import com.disenio.dto.publicacion.DTOPublicacionPerdida;
import com.disenio.model.mascotas.MascotaHogarTransito;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.mascotas.UbicacionMascotaRescatada;
import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.mascotas.MascotaRescatadaService;
import com.disenio.services.mascotas.TamanioMascotaService;
import com.disenio.services.mascotas.TipoMascotaService;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.publicaciones.PublicacionService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/publicaciones/perdidas")
public class PublicacionPerdidasController {
    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private PersonaService personaService;

    @Autowired
    private TamanioMascotaService tamanioMascotaService;
    @Autowired
    private TipoMascotaService tipoMascotaService;
    @Autowired
    private MascotaRescatadaService mascotaService;


    @PostMapping(path = "/guardar")
    public ResponseEntity<DTOResponse> guardar(HttpServletRequest request, @RequestBody DTOPublicacionPerdida dtoPublicacion) {

        DTOPersona dtoPersona = dtoPublicacion.getAutor();
        DTOMascotaPerdida dtoMascota = dtoPublicacion.getMascota();
        DTOResponse dtoResponse = new DTOResponse();
        DTOUbicacionMascota ubicacionDTO = dtoMascota.getUbicacion();

        UbicacionMascotaRescatada ubicacion = new UbicacionMascotaRescatada(ubicacionDTO.getDireccion(), ubicacionDTO.getLatitud(), ubicacionDTO.getLongitud());
        MascotaHogarTransito mht = new MascotaHogarTransito(dtoPublicacion.getIdHogar());
        Persona persona = personaService.getPersonasById(dtoPersona.getIdPersona()).orElse(null);
        MascotaRescatada mascotaPerdida = new MascotaRescatada(persona, dtoMascota.getTamanioMascota(), dtoMascota.getTipoMascota(), dtoPublicacion.getDescripcion());

        mascotaPerdida.setMascotaHogarTransitos(mht);
        mascotaPerdida.setUbicacionMascotaRescatadas(ubicacion);
        //TODO: Aca se hace la verificacion de si puede la mascota ir o no a ese hogar

        PublicacionPerdida publicacion = new PublicacionPerdida(persona, mascotaPerdida, mht);


        if (persona == null) {
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            dtoResponse.setMsg("No se pudo crear la publicacion");
            return new ResponseEntity(dtoResponse, HttpStatus.NO_CONTENT);
        }

        mascotaService.alta(mascotaPerdida);
        publicacionService.alta(publicacion);


        dtoResponse.setStatus(HttpStatus.CREATED);
        dtoResponse.setMsg("Se creo la publicacion satisfactoriamente");
        return new ResponseEntity(dtoResponse, HttpStatus.CREATED);

    }
    /* TODO :Terminar eliminar
    @DeleteMapping(path = "/borrar")
    public ResponseEntity<PublicacionPerdida> guardar(HttpServletRequest request, @RequestBody PublicacionPerdida publicacion) {
        return new ResponseEntity(publicacionService.alta(publicacion), HttpStatus.CREATED);
    }
    */


    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOResponse> getPublicacionesPerdidasByID(@PathVariable("id") Integer id) {
        DTOResponse dtoResponse = new DTOResponse();

        PublicacionPerdida publicacion = (PublicacionPerdida) publicacionService.getById(id).orElseGet(null);
        DTOPublicacionPerdida dtoPublicacion = new DTOPublicacionPerdida(publicacion);

        if (dtoPublicacion.getMascota() == null || dtoPublicacion.getIdPublicacion() == null || dtoPublicacion.getAutor() == null) {
            dtoResponse.setStatus(HttpStatus.NO_CONTENT);
            dtoResponse.setMsg("No existen publicacion.");
            return ResponseEntity.ok(dtoResponse);
        }
        dtoResponse.setStatus(HttpStatus.OK);
        dtoResponse.setData(dtoPublicacion);
        return ResponseEntity.ok(dtoResponse);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<DTOResponse> getPublicacionesPerdidasAll() {
        DTOResponse response = new DTOResponse();
        List<PublicacionPerdida> publicaciones = publicacionService.listarPerdidas();
        List<DTOPublicacionPerdida> dtoPublicaciones;

        dtoPublicaciones = publicaciones.stream()
                .map(DTOPublicacionPerdida::new)
                .collect(Collectors.toList());

        response.setStatus(HttpStatus.OK);
        response.setData(dtoPublicaciones);


        return ResponseEntity.ok(response);
    }
}
