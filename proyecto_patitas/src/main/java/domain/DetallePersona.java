package domain;

import domain.notificacion.MedioDeNotificacion;

import java.util.Date;
import java.util.List;

public class DetallePersona {
    private String nombre;
    private Date fechaDeNacimiento;
    private Documento documento;
    private String nroDocumento;
    private List<Contacto> contactos;
    private List<Mascota> mascotas;
    //todo implementar codigoQR
    private MedioDeNotificacion medioDeNotificacion;
}
