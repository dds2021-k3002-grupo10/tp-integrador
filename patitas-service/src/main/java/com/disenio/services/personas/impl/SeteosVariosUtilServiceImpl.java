package com.disenio.services.personas.impl;

import com.disenio.dto.persona.DocumentoAltaDTO;
import com.disenio.dto.persona.PersonaAltaDTO;
import com.disenio.model.personas.Persona;
import com.disenio.model.personas.PersonaDocumento;
import com.disenio.model.personas.TipoDocumento;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SeteosVariosUtilServiceImpl {


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


        return rtaPersona;
    }


    public List<PersonaDocumento> setDocumentos(List<DocumentoAltaDTO> documentoAltaDTOS) {
        /*fechaActual*/
        Calendar fechaActualCalendar = Calendar.getInstance();

        List<PersonaDocumento> personaDocumentos = new ArrayList<>();
        for (DocumentoAltaDTO documentoAltaDTO : documentoAltaDTOS) {
            PersonaDocumento personaDocumento = new PersonaDocumento();
            personaDocumento.setNumero(documentoAltaDTO.getNumero());
            personaDocumento.setFechaAlta(fechaActualCalendar);
            personaDocumento.setFechaUltimaModificacion(fechaActualCalendar);
            personaDocumento.setEstado('A');

            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setIdTipoDoc(documentoAltaDTO.getIdTipoDoc());
            personaDocumento.setTipoDocumento(tipoDocumento);
            personaDocumentos.add(personaDocumento);

        }
        return personaDocumentos;
    }
}
