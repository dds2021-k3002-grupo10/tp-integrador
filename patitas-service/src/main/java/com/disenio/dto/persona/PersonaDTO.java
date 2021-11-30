package com.disenio.dto.persona;

import com.disenio.model.mascotas.Mascota;
import com.disenio.model.mascotas.MascotaRescatada;
import com.disenio.model.personas.PersonaContacto;
import com.disenio.model.personas.PersonaDireccion;
import com.disenio.model.personas.PersonaDocumento;
import com.disenio.model.usuarios.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
public class PersonaDTO {
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;
    private char estado;
    private PersonaDocumentoDTO personaDocumentos ;
    private PersonaDireccionDTO personaDireccions;
}
