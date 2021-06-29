package domain;

import domain.notificacion.MedioDeNotificacion;

import java.util.Date;
import java.util.List;

public class Persona {
    private String nombre;
    private Date fechaDeNacimiento;
    private Documento documento;
    private String nroDocumento;
    private List<Contacto> contactos;
    
    public void notificar(){
        contactos.stream().forEach(contacto -> contacto.notificar());
    }
}
