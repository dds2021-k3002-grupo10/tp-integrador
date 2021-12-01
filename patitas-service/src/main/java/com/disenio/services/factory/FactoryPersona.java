package com.disenio.services.factory;

import com.disenio.dto.persona.*;
import com.disenio.model.notificacion.MedioNotificacion;
import com.disenio.model.personas.*;
import com.disenio.services.builder.impl.BuilderPersona;
import com.disenio.services.personas.MedioNotificacionService;
import com.disenio.services.personas.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactoryPersona implements Factory<Persona, PersonaAltaDTO> {
    private final SimpleDateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");
    final private BuilderPersona builder = new BuilderPersona();

    @Autowired
    MedioNotificacionService medioNotificacionService;

    @Autowired
    TipoDocumentoService tipoDocumentoService;


    public Persona createFromDTO(PersonaAltaDTO persona) {

        Calendar fechaNacimiento = null;
        try {
            fechaNacimiento = this.converterCalendarFromString(persona.getFechaNacimiento());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar fechaActual = Calendar.getInstance();
        List<PersonaContacto> contactos;
        //PersonaDireccion personaDireccion = this.createPersonaDireccionFromDTO(persona.get());
        PersonaDocumento personaDocumento = this.createPersonaDocumentoFromDTO(persona.getDocumento().get(0));

        contactos = persona.getContactos()
                .stream()
                .map(this::createPersonaContactoFromDTO)
                .collect(Collectors.toList());


        return builder.setApellido(persona.getApellido())
                .setNombre(persona.getNombre())
                .setEstado('A')
                .setFechaAlta(fechaActual)
                .setFechaNacimiento(fechaNacimiento)
                .setFechaBaja(null)
                .setFechaUltimaModificacion(fechaActual)
                .setPersonaContactos(contactos)
                //.setPersonaDireccions(personaDireccion)
                .setPersonaDocumentos(personaDocumento)
                .create();
    }

    public PersonaDireccion createPersonaDireccionFromDTO(PersonaDireccionDTO direccion) {
        PersonaDireccion personaDireccion = new PersonaDireccion();
        personaDireccion.setCalle(direccion.getCalle());
        personaDireccion.setCodPostal(direccion.getCodPostal());
        personaDireccion.setNumero(direccion.getNumero());
        personaDireccion.setObservaciones(direccion.getObservaciones());
        personaDireccion.setPiso(direccion.getPiso());
        personaDireccion.setDepartamento(direccion.getDepartamento());

        return personaDireccion;
    }

    public PersonaDocumento createPersonaDocumentoFromDTO(DocumentoAltaDTO documentoDTO) {
        PersonaDocumento personaDocumento = new PersonaDocumento();
        TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocuemntoById(documentoDTO.getIdTipoDoc()).get();

        personaDocumento.setTipoDocumento(tipoDocumento);
        personaDocumento.setNumero(documentoDTO.getNumero());


        return personaDocumento;
    }

    public TipoDocumento createTipoDocumentoFromDTO(TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setDescripcionCorta(tipoDocumentoDTO.getDescripcionCorta());
        tipoDocumento.setDescripcionLarga(tipoDocumentoDTO.getDescripcionLarga());
        tipoDocumento.setIdTipoDoc(tipoDocumentoDTO.getIdTipoDoc());

        return tipoDocumento;
    }


    public PersonaContacto createPersonaContactoFromDTO(ContactosAltaDTO contacto) {
        MedioNotificacion medioNotificacion = medioNotificacionService.getMedioNotificacionByID(contacto.getIdNotificacion());
        PersonaContacto personaContacto = new PersonaContacto();
        personaContacto.setApellido(contacto.getApellidoContacto());
        personaContacto.setNombre(contacto.getNombreContacto());
        personaContacto.setTelefono(contacto.getTelefonoContacto());
        personaContacto.setEmail(contacto.getEmailContacto());
        personaContacto.setMedioNotificacion(medioNotificacion);
        return personaContacto;

    }


    private Calendar converterCalendarFromString(String fecha) throws ParseException {
        Date fechaNacimiento = FORMATO.parse(fecha);
        Calendar fechaNacimientoCal = Calendar.getInstance();

        fechaNacimientoCal.setTime(fechaNacimiento);
        return fechaNacimientoCal;
    }
}
