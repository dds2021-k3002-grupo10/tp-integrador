package com.disenio.services.personas.impl;

import com.disenio.dao.persona.PersonaDAO;
import com.disenio.dto.persona.PersonaAltaDTO;
import com.disenio.dto.persona.PersonaBusquedaByDocDTO;
import com.disenio.dto.persona.PersonaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.services.mascotas.MascotasService;
import com.disenio.services.personas.PersonaContactoService;
import com.disenio.services.personas.PersonaDireccionService;
import com.disenio.services.personas.PersonaDocumentoService;
import com.disenio.services.personas.PersonaService;
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
    @Qualifier("PersonaDAO")
    private PersonaDAO personaDAO;
    @Autowired
    private PersonaDocumentoService personaDocumentoService;
    @Autowired
    PersonaDireccionService personaDireccionService;
    @Autowired
    PersonaContactoService personaContactoService;
    @Autowired
    MascotasService mascotasService;
    @Autowired
    SeteosVariosUtilServiceImpl seteosVariosUtilService;

    @Transactional
    @Override
    public Persona alta(PersonaAltaDTO personaAltaDTO) throws ParseException {
        //AltaPersona
        Persona rtaPersona= personaDAO.save(seteosVariosUtilService.setPersonaAlta(personaAltaDTO));

        //AltaPersonaDocumento
        personaDocumentoService.alta(personaAltaDTO.getDocumento(), rtaPersona);


        //AltaPersonaContacto
        personaContactoService.alta(personaAltaDTO.getContactos(),rtaPersona);

        //AltaMascota
       // mascotasService.alta(persona.getMascotas(),rtaPersona);


        return rtaPersona;

    }

    @Override
    public List<PersonaDTO> getListaAllPersona() {

        List<Persona> persona  =personaDAO.findAll();


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
        if(persona.isPresent()){
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
        List<Persona> listPersona  =personaDAO.findPersonasByCondicion(idTipoDoc,numero);

        List<PersonaBusquedaByDocDTO> personasDTOList = new ArrayList<PersonaBusquedaByDocDTO>();

        for (Persona persona:listPersona){

            PersonaBusquedaByDocDTO personaBusquedaByDocDTO= new PersonaBusquedaByDocDTO();
            personaBusquedaByDocDTO.setIdPersona(persona.getIdPersona());
            personaBusquedaByDocDTO.setNombre(persona.getNombre());
            personaBusquedaByDocDTO.setApellido(persona.getApellido());
            personaBusquedaByDocDTO.setTipoDoc(persona.getPersonaDocumentos().get(0).getTipoDocumento().getDescripcionCorta());
            personaBusquedaByDocDTO.setNroDoc(persona.getPersonaDocumentos().get(0).getNumero());
            personaBusquedaByDocDTO.setCantidadMascota(persona.getMascotas().size());
            personaBusquedaByDocDTO.setEstado(persona.getEstado());

            personasDTOList.add(personaBusquedaByDocDTO);
        }

        return personasDTOList;
    }


}
