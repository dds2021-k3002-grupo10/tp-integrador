package domain.notificacion;

import domain.Contacto;

public interface MedioDeNotificacion {
    public static final String account_sid = "ACeaa8f461078d22c1151d283f54cafc8a";
    public static final String auth_token = "df274d91aa9f994fdde961ff6e2ee496";

    public void notificar(Contacto contacto, String mensaje);
}
