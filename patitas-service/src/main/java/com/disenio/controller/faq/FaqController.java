package com.disenio.controller.faq;

import com.disenio.dto.faq.FaqDTO;
import com.disenio.services.faq.FaqService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/faq")
public class FaqController {
    private static final Logger LOGGER = Logger.getLogger(FaqController.class);
    @Autowired
    private FaqService faqService;

    /*@PostMapping("/guardar")
    public ResponseEntity alta(HttpServletRequest request, @RequestBody Caracteristica caracteristica) {
        ResponseEntity response;
        try {
            caracteristicaService.alta(caracteristica);
            response = new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
            LOGGER.error("Ocurrio un error al dar de Alta una caracterstica", e);
        }
        return response;
    }*/

    @RequestMapping(value = "/organizacion/{idOrganizacion}/pregunta-tipo/{idPreguntaTipo}", method = RequestMethod.GET)
    @ApiOperation(value = "", notes = "Trae las preguntas con sus respuestas filtrado por organizacion y tipoPregunta ejemplo establecimento")
    public ResponseEntity<?> getFaqAllByOrganizacionAndPreguntaTipo(@RequestParam(required = true) Integer idOrganizacion,
                                                                    @RequestParam(required = true) Integer idPreguntaTipo) {
        try {
            List<FaqDTO> faqDTO = faqService.getFaqAllByOrganizacionAndPreguntaTipo(idOrganizacion, idPreguntaTipo);
            if (faqDTO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body("{\"description\":\"No se encontro resultados\"}");
            }

            return ResponseEntity.ok(faqDTO);
        } catch (HttpClientErrorException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"error\":\"Ha ocurrido un error: " + ex + "\"}");
        }
    }

}


