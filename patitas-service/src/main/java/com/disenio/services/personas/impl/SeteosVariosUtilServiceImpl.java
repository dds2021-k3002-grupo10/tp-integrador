package com.disenio.services.personas.impl;

import com.disenio.dto.persona.ContactosAltaDTO;
import com.disenio.dto.persona.DocumentoAltaDTO;
import com.disenio.dto.persona.PersonaAltaDTO;
import com.disenio.model.notificacion.MedioNotificacion;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.model.personas.PersonaDocumento;
import com.disenio.model.personas.TipoDocumento;
import com.disenio.services.personas.MedioNotificacionService;
import com.disenio.services.personas.PersonaContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SeteosVariosUtilServiceImpl {
    @Autowired
    MedioNotificacionService medioNotificacionService;
    @Autowired
    PersonaContactoService personaContactoService;

    /*Set PErsona Alta*/
    public Persona setPersonaAlta(PersonaAltaDTO personaAltaDTO) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        /*fecha Nacimiento a DAte*/
        Date fechaNacimiento = formato.parse(personaAltaDTO.getFechaNacimiento());
        Calendar fechaNacimientoCal = Calendar.getInstance();
        fechaNacimientoCal.setTime(fechaNacimiento);

        /*fechaActual*/
        Calendar fechaActualCalendar = Calendar.getInstance();

        Persona rtaPersona = new Persona();
        rtaPersona.setApellido(personaAltaDTO.getApellido().toUpperCase());
        rtaPersona.setNombre(personaAltaDTO.getNombre().toUpperCase());
        rtaPersona.setFechaNacimiento(fechaNacimientoCal);
        rtaPersona.setFechaAlta(fechaActualCalendar);
        rtaPersona.setFechaUltimaModificacion(fechaActualCalendar);
        rtaPersona.setEstado('A');
        List<PersonaContacto> personaContactos = new ArrayList<>();
        personaAltaDTO.getContactos().forEach(contactosAltaDTO -> {
            PersonaContacto personaContacto = new PersonaContacto();
            personaContacto.setApellido(contactosAltaDTO.getApellidoContacto());
            personaContacto.setNombre(contactosAltaDTO.getNombreContacto());
            personaContacto.setTelefono(contactosAltaDTO.getTelefonoContacto());
            personaContacto.setEmail(contactosAltaDTO.getEmailContacto());
           // MedioNotificacion medioNotificacion = medioNotificacionService.getMedioNotificacionByID(contactosAltaDTO.getIdNotificacion());
            //personaContacto.setMedioNotificacion(medioNotificacion);
            personaContactos.add(personaContacto);
        });

        PersonaContacto personaContacto = new PersonaContacto();
        personaContacto.setApellido(personaAltaDTO.getApellido());
        personaContacto.setNombre(personaAltaDTO.getNombre());
        personaContacto.setTelefono(personaContacto.getTelefono());
        personaContacto.setEmail(personaContacto.getEmail());
       // Integer idNotificacion =personaAltaDTO.getIdNotificacion();
        //MedioNotificacion medioNotificacion = medioNotificacionService.getMedioNotificacionByID(idNotificacion);
        //personaContacto.setMedioNotificacion(medioNotificacion);
        personaContactos.add(personaContacto);


        rtaPersona.setPersonaContactos(new ArrayList<>(new HashSet<>(personaContactos)));


        return rtaPersona;
    }


    public PersonaDocumento setDocumento(DocumentoAltaDTO documentoAltaDTO) {
        Calendar fechaActualCalendar = Calendar.getInstance();

        PersonaDocumento personaDocumento = new PersonaDocumento();
        personaDocumento.setNumero(documentoAltaDTO.getNumero());
        personaDocumento.setFechaAlta(fechaActualCalendar);
        personaDocumento.setFechaUltimaModificacion(fechaActualCalendar);
        personaDocumento.setEstado('A');

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDoc(documentoAltaDTO.getIdTipoDoc());
        personaDocumento.setTipoDocumento(tipoDocumento);


        return personaDocumento;
    }

    /*Set Documentos Alta*/
    public List<PersonaDocumento> setDocumentos(List<DocumentoAltaDTO> documentoAltaDTOS) {
        /*fechaActual*/
        Calendar fechaActualCalendar = Calendar.getInstance();

        List<PersonaDocumento> personaDocumentos = new ArrayList<>();
        for (DocumentoAltaDTO documentoAltaDTO : documentoAltaDTOS) {
            personaDocumentos.add(this.setDocumento(documentoAltaDTO));

        }
        return personaDocumentos;
    }


    /*Set Contactos Alta*/
    public List<PersonaContacto> setContactosAlta(List<ContactosAltaDTO> listContactosAltaDTOS, Persona persona) throws ParseException {
        /*fechaActual*/
        Calendar fechaActualCalendar = Calendar.getInstance();

        List<PersonaContacto> personaContactos = new ArrayList<>();
        for (ContactosAltaDTO contactosAltaDTO : listContactosAltaDTOS) {
            PersonaContacto rtaPersonaContacto = new PersonaContacto();
            rtaPersonaContacto.setNombre(contactosAltaDTO.getNombreContacto());
            rtaPersonaContacto.setApellido(contactosAltaDTO.getApellidoContacto());
            rtaPersonaContacto.setEmail(contactosAltaDTO.getEmailContacto());
            rtaPersonaContacto.setTelefono(contactosAltaDTO.getTelefonoContacto());
            rtaPersonaContacto.setFechaAlta(fechaActualCalendar);
            rtaPersonaContacto.setFechaUltimaModificacion(fechaActualCalendar);
            rtaPersonaContacto.setEstado('A');

            /*id medio notificacion*/
            MedioNotificacion medioNotificacion = medioNotificacionService.getMedioNotificacionByID(contactosAltaDTO.getIdNotificacion());
            //medioNotificacion.setIdMedioNotificacion(contactosAltaDTO.getIdNotificacion());
            rtaPersonaContacto.setMedioNotificacion(medioNotificacion);
            personaContactos.add(rtaPersonaContacto);
        }

        return personaContactos;
    }

}
