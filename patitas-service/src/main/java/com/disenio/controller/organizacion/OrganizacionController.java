package com.disenio.controller.organizacion;

import com.disenio.dto.organizacion.OrganizacionDTO;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.services.organizacion.OrganizacionService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/organizacion")
public class OrganizacionController {

    private static final Logger LOGGER = Logger.getLogger(OrganizacionController.class);
    @Autowired
    private OrganizacionService organizacionService;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrganizacionAll(@PathVariable("id") Integer id, HttpServletRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        OrganizacionDTO organizacionDTO = modelMapper.map(organizacionService.getOrganizacionById(id), OrganizacionDTO.class);
        /*if (organizacionDTO.isEmpty()) {
            response = ResponseEntity.noContent().build();
        } else {
         */
        return ResponseEntity.ok(organizacionDTO);
    }


    @PostMapping("/{id}")
    public ResponseEntity<String> getOrganizacionGetByID(@PathVariable("id") Integer id, HttpServletRequest request) {
        Organizacion organizacion = organizacionService.getOrganizacionById(id);


        if (organizacion == null) {
            return ResponseEntity.noContent().build();
        } else {
            //request.getSession().removeAttribute("organizacion");
            request.getSession().setAttribute("organizacion", organizacion.getIdOrganizacion());
            return ResponseEntity.ok().build();
        }
    }
}
