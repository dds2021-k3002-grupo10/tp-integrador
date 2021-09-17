package domain.notificacion;

import domain.Contacto;

public interface MedioDeNotificacion {
    public static final String account_sid = "ACeaa8f461078d22c1151d283f54cafc8a";
    public static final String auth_token = "c9ab051438b9b34c802a965bbfc8739a";

    public void notificar(Contacto contacto, String mensaje);
}
