package domain;

import java.util.Date;
import java.util.List;

public class Persona {
    private String nombre;
    private Date fechaDeNacimiento;
    private Documento documento;
    private String nroDocumento;
    private List<Contacto> contactos;

    public Persona(String nombre, Date fechaDeNacimiento, Documento documento, String nroDocumento, List<Contacto> contactos) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.documento = documento;
        this.nroDocumento = nroDocumento;
        this.contactos = contactos;
    }

    //Accessors
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    //Funcionalidad
    public void notificar(String mensaje) {
        contactos.stream().forEach(contacto -> contacto.notificar(mensaje));
    }


}
