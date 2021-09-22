package domain.notificacion;

import domain.Contacto;

public interface MedioDeNotificacion {
    public static final String account_sid = "ACeaa8f461078d22c1151d283f54cafc8a";
    public static final String auth_token = "87ff46721e8a12dc9ce1158e5c4a3b29";

    public void notificar(Contacto contacto, String mensaje);
}
