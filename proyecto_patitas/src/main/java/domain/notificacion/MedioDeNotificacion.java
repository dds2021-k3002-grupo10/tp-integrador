package domain.notificacion;

import domain.Contacto;
import domain.DetallePersona;

public interface MedioDeNotificacion {
    public void notificar(DetallePersona dueno);
}
