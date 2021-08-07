package views;

import domain.Persona;
import domain.entities.MascotaEncontrada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MascotaEncontradaView {
    public MascotaEncontrada ejecutar(Persona rescatista){
        System.out.println("Seleccione tipo de mascota perro o gato");
        Scanner tipoIngresado = new Scanner(System.in);
        String tipoDeMascota = tipoIngresado.nextLine();

        System.out.println("Seleccione tamaño de mascota chica, mediana, grande");
        Scanner tamañoIngresado = new Scanner(System.in);
        String tamañoMascota = tamañoIngresado.nextLine();

        System.out.println("Tiene chapita?");
        Scanner opcionIngresada = new Scanner(System.in);
        boolean chapita;
        if(opcionIngresada.nextLine() == "si")
            chapita = true;
        else
            chapita = false;

        System.out.println("A continuación agregue caracteristicas que tenga la mascota: ");
        int opcionElegida = 1;
        List<String> caracteristicas = new ArrayList<>();
        while(opcionElegida != 0){
            Scanner caracteristicaIngresada = new Scanner(System.in);
            String caracterisiticaMascota = caracteristicaIngresada.nextLine();
            caracteristicas.add(caracterisiticaMascota);
            System.out.println("Ingresar una nueva caracteristica? 0/1");
            Scanner opcion = new Scanner(System.in);
            opcionElegida = opcion.nextInt();
        }

        MascotaEncontrada mascotaEncontrada = new MascotaEncontrada(rescatista, tipoDeMascota, tamañoMascota, caracteristicas, chapita);

        return mascotaEncontrada;
    }
}
