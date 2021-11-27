package com.disenio.controller.mascotas;

import com.disenio.dto.mascota.MascotaDTO;
import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.services.mascotas.MascotasService;
import com.disenio.services.mascotas.SexoMascotaService;
import com.disenio.services.mascotas.TipoMascotaService;
import com.fasterxml.jackson.annotation.JsonView;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mascota")
public class MascotaController {
    private static final Logger LOGGER = Logger.getLogger(MascotaController.class);
    @Autowired
    TipoMascotaService tipoMascotaService;
    @Autowired
    SexoMascotaService sexoMascotaService;
    @Autowired
    MascotasService mascotasService;

    @RequestMapping(value = "/tipo", method = RequestMethod.GET)
    public ResponseEntity<List<TipoMascota>> getTipoMascotaAll() {
        ResponseEntity<List<TipoMascota>> response;
        List<TipoMascota> tipoMascota = tipoMascotaService.getAllTipoMascota();

        if (tipoMascota.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(tipoMascota);
        }
        return response;
    }

    @RequestMapping(value = "/sexo", method = RequestMethod.GET)
    public ResponseEntity<List<SexoMascota>> getSexoMascotaAll() {
        ResponseEntity<List<SexoMascota>> response;

        List<SexoMascota> sexoMascota = sexoMascotaService.getAllSexoMascota();
        if (sexoMascota.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(sexoMascota);
        }
        return response;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MascotaDTO>> getMascotaAll() {
        ResponseEntity<List<MascotaDTO>> response;

        List<MascotaDTO> rtaMascotas = mascotasService.getMascotasAll();
        if (rtaMascotas.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(rtaMascotas);
        }
        return response;
    }
}
