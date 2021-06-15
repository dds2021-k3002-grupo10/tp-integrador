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


}
