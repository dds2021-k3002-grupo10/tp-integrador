package domain;

import domain.notificacion.MedioDeNotificacion;

public class Contacto {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private MedioDeNotificacion medioDeNotificacion;

    public Contacto(String nombre, String apellido, String email, String telefono, MedioDeNotificacion medioDeNotificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.medioDeNotificacion = medioDeNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MedioDeNotificacion getMedioDeNotificacion() {
        return this.medioDeNotificacion;
    }

    public void setMedioDeNotificacion(MedioDeNotificacion medioDeNotificacion) {
        this.medioDeNotificacion = medioDeNotificacion;
    }

    public void notificar(String mensaje) {
        this.medioDeNotificacion.notificar(this, mensaje);
    }
}
