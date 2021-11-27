package com.disenio.controller.organizacion;

import com.disenio.dto.organizacion.OrganizacionDTO;
import com.disenio.services.organizacion.OrganizacionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/organizacion")
public class OrganizacionController {

    @Autowired
    private OrganizacionService organizacionService;
    private static final Logger LOGGER = Logger.getLogger(OrganizacionController.class);

    @GetMapping("/all")
    public ResponseEntity<?> getOrganizacionAll() {
        ResponseEntity<List<OrganizacionDTO>> response;
        List<OrganizacionDTO> organizacionDTO = organizacionService.getOrganizacionAll();

        if (organizacionDTO.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(organizacionDTO);
        }
        return response;
    }
}
