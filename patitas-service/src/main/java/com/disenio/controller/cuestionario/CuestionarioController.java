package com.disenio.controller.cuestionario;

import com.disenio.dto.DTOResponse;
import com.disenio.dto.cuestionario.DTOCuestionario;
import com.disenio.model.cuestionario.Cuestionario;
import com.disenio.model.organizacion.Organizacion;
import com.disenio.services.organizacion.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cuestionario")
public class CuestionarioController {

    @Autowired
    OrganizacionService organizacionService;

    @GetMapping(path = "/adopcion")
    public ResponseEntity<DTOResponse> mascotaDarAdopcion(HttpServletRequest request) {
        DTOResponse response = new DTOResponse();
        //TODO: Session!
        //Organizacion organizacion = request.getSession().getAttribute("organizacion");
        Organizacion organizacion = organizacionService.getOrganizacionById(1).get();
        Cuestionario cuestionario = organizacion.getCuestionarioByCuestionarioDeAdopcionIdCuestionario();

        DTOCuestionario dtoCuestionario = new DTOCuestionario(cuestionario);

        response.setStatus(HttpStatus.OK);
        response.setData(dtoCuestionario);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/adoptante")
    public ResponseEntity<DTOResponse> mascotaAdoptante(HttpServletRequest request) {
        DTOResponse response = new DTOResponse();
        //TODO: Session!
        //Organizacion organizacion = request.getSession().getAttribute("organizacion");
        Organizacion organizacion = organizacionService.getOrganizacionById(1).get();
        Cuestionario cuestionario = organizacion.getCuestionarioByCuestionarioDeAdopcionIdCuestionario();

        DTOCuestionario dtoCuestionario = new DTOCuestionario(cuestionario);



        response.setStatus(HttpStatus.OK);
        response.setData(dtoCuestionario);

        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
