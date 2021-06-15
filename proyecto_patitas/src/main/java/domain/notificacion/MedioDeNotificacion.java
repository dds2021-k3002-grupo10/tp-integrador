package domain.notificacion;

import domain.Contacto;
import domain.DetallePersona;

public interface MedioDeNotificacion {
    public static final String account_sid = "ACeaa8f461078d22c1151d283f54cafc8a";
    public static final String auth_token = "f83bf192a77373158571daff8da84a3b";

    public void notificar(Contacto contacto);
}
