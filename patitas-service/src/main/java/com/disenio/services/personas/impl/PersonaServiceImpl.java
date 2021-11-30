package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaDAO;
import com.disenio.dto.persona.PersonaAltaDTO;
import com.disenio.dto.persona.PersonaBusquedaByDocDTO;
import com.disenio.dto.persona.PersonaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.usuarios.Usuario;
import com.disenio.services.mascotas.MascotasService;
import com.disenio.services.personas.PersonaContactoService;
import com.disenio.services.personas.PersonaDireccionService;
import com.disenio.services.personas.PersonaDocumentoService;
import com.disenio.services.personas.PersonaService;
import com.disenio.services.usuarios.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service()
public class PersonaServiceImpl implements PersonaService {
    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PersonaDireccionService personaDireccionService;
    @Autowired
    PersonaContactoService personaContactoService;
    @Autowired
    MascotasService mascotasService;
    @Autowired
    SeteosVariosUtilServiceImpl seteosVariosUtilService;
    @Autowired
    @Qualifier("PersonaDAO")
    private PersonaDAO personaDAO;
    @Autowired
    private PersonaDocumentoService personaDocumentoService;

    @Transactional
    @Override
    public PersonaAltaDTO alta(PersonaAltaDTO personaAltaDTO, Usuario usuario) throws ParseException {
        //AltaPersona
        Persona rtaPersona = personaDAO.save(seteosVariosUtilService.setPersonaAlta(personaAltaDTO));

        PersonaAltaDTO personaAltaDTO1 = new PersonaAltaDTO();
        //datos para enviar a vista
        personaAltaDTO1.setIdPersona(rtaPersona.getIdPersona());
        personaAltaDTO1.setRespuesta("ok");
        personaAltaDTO1.setNombre(rtaPersona.getNombre());
        personaAltaDTO1.setApellido(rtaPersona.getApellido());


        return personaAltaDTO1;

    }

    @Override
    public void alta(Persona persona) throws ParseException {
        personaDAO.save(persona);
    }

    @Override
    public List<PersonaDTO> getListaAllPersona() {

        List<Persona> persona = personaDAO.findAll();


        List<PersonaDTO> personaDTO = new ArrayList<PersonaDTO>();
        if (!persona.isEmpty()) {
            personaDTO = Arrays.asList(modelMapper.map(persona, PersonaDTO[].class));
        }
        return personaDTO;
    }

    @Override
    public PersonaDTO getPersonaDTOById(Integer id) {
        Optional<Persona> persona = personaDAO.findById(id);

        PersonaDTO personaDTO = null;
        if (persona.isPresent()) {
            personaDTO = new PersonaDTO();
            personaDTO = modelMapper.map(persona.get(), PersonaDTO.class);

        }

        return personaDTO;
    }

    @Override
    public Optional<Persona> getPersonasById(Integer id) {
        return personaDAO.findById(id);
    }

    @Override
    public List<PersonaBusquedaByDocDTO> getPersonasByCondicion(Integer idTipoDoc, Integer numero) {
        List<Persona> listPersona = personaDAO.findPersonasByCondicion(idTipoDoc, numero);

        PersonaBusquedaByDocDTO personasDTOList = new PersonaBusquedaByDocDTO();

        for (Persona persona : listPersona) {

            PersonaBusquedaByDocDTO personaBusquedaByDocDTO = new PersonaBusquedaByDocDTO();
            personaBusquedaByDocDTO.setIdPersona(persona.getIdPersona());
            personaBusquedaByDocDTO.setNombre(persona.getNombre());
            personaBusquedaByDocDTO.setApellido(persona.getApellido());
            personaBusquedaByDocDTO.setTipoDoc(persona.getPersonaDocumentos().getTipoDocumento().getDescripcionCorta());
            personaBusquedaByDocDTO.setNroDoc(persona.getPersonaDocumentos().getNumero());
            personaBusquedaByDocDTO.setCantidadMascota(persona.getMascotas().size());
            personaBusquedaByDocDTO.setEstado(persona.getEstado());


        }

        return Arrays.asList(personasDTOList);//TODO: HARDCODE
    }


}
