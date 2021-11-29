package com.disenio.controller.view;

import com.disenio.model.personas.Persona;
import com.disenio.model.publicaciones.PublicacionAdoptante;
import com.disenio.model.publicaciones.PublicacionDarAdopcion;
import com.disenio.model.publicaciones.PublicacionPerdida;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.publicaciones.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("view/publicacion")
public class ViewPublicaciones {
    @Autowired
    private PublicacionService publicacionService;
    @Autowired
    private PersonaService personaService;

    @GetMapping("/perdida")
    public ModelAndView displayArticle(Map<String, Object> model) {
        List<PublicacionPerdida> publicaciones = publicacionService.listarPerdidas();
        model.put("publicacion", publicaciones);

        return new ModelAndView("principal", model);
    }

    @GetMapping("/adoptar")
    public ModelAndView viewPublicacionAdoptar(Map<String, Object> model) {
        List<PublicacionDarAdopcion> publicaciones = publicacionService.listarDarAdopcion();
        model.put("publicacion", publicaciones);
        model.put("esPublicacionAdoptar", true);

        return new ModelAndView("principal", model);
    }

    @GetMapping("/adoptante")
    public ModelAndView viewPublicacionAdoptante(Map<String, Object> model) {
        List<PublicacionAdoptante> publicaciones = publicacionService.listarAdoptante();
        model.put("publicacion", publicaciones);
        model.put("esPublicacionAdoptante", true);

        return new ModelAndView("principal", model);
    }


}