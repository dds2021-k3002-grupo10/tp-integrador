package views;

import domain.entities.caracteristicas.Caracteristicas;
import domain.entities.caracteristicas.Valores;
import services.CaracteristicaValorService;

import java.io.IOException;
import java.util.List;

public class OrganizacionView {
    public void agregarCaracteristicas() throws IOException {
        CaracteristicaValorService caracteristicaValorService = new CaracteristicaValorService();
        caracteristicaValorService.setCaracteristicaValor();
    }

    //puede llamarce getCaracteristicas
    //en este caso no le envio nada, pero se debe enviar el idOrganizacion
    public void mostrarCaracteristicas() {

        CaracteristicaValorService caracteristicaValorService = new CaracteristicaValorService();
        List<Caracteristicas> caracteristicas = caracteristicaValorService.getCaracteristicaValor();
        imprimirResultado(caracteristicas);

    }

    private void imprimirResultado(List<Caracteristicas> caracteristicasList) {

        for (Caracteristicas caracteristica : caracteristicasList) {
            System.out.println("*************CARACTERISTICAS*************");
            System.out.println("PREGUNTA: " + caracteristica.getDescripcionFaq());
            System.out.println("TIPO BUTTON: " + caracteristica.getComportamiento().getDescripcion());
            System.out.println("SELECCIONE RESPUESTA: ");
            for (Valores valor : caracteristica.getValores()) {
                System.out.println(valor.getId() + "--->" + valor.getDescripcion());
            }
        }

    }
}
