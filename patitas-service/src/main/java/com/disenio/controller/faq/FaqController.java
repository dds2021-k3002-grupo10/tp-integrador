package com.disenio.controller.faq;

import com.disenio.dto.faq.FaqALtaDTO;
import com.disenio.dto.faq.FaqDTO;
import com.disenio.model.faq.Faq;
import com.disenio.services.faq.FaqService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/faq")
public class FaqController {
    private static final Logger LOGGER = Logger.getLogger(FaqController.class);
    @Autowired
    private FaqService faqService;

    @PostMapping("/alta")
    public ResponseEntity alta( @RequestBody FaqALtaDTO faqAltaDTO) {
        ResponseEntity response;
        try {
            faqService.alta(faqAltaDTO);
            response = new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
            LOGGER.error("Ocurrio un error al dar de Alta Las Preguntas", e);
        }
        return response;
    }

    @RequestMapping(value = "/organizacion/pregunta-tipo", method = RequestMethod.GET)
   // @ApiOperation(value = "", notes = "Trae las preguntas con sus respuestas filtrado por organizacion y tipoPregunta ejemplo establecimento")
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


