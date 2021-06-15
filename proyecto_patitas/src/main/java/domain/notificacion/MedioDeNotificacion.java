package domain.notificacion;

import domain.Contacto;

public interface MedioDeNotificacion {
    public void notificar(Contacto contacto);
}
