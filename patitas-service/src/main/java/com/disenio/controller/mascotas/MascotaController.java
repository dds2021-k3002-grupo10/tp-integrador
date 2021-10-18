package com.disenio.controller.mascotas;

import com.disenio.controller.personas.PersonaController;
import com.disenio.model.mascotas.SexoMascota;
import com.disenio.model.mascotas.TipoMascota;
import com.disenio.model.personas.TipoDocumento;
import com.disenio.services.mascotas.SexoMascotaService;
import com.disenio.services.mascotas.TipoMascotaService;
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
}
