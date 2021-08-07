package views;

import java.util.Scanner;

public class PersonaView {
    public void ejecutar(){
        System.out.println("Ingrese su nombre y apellido");
        Scanner nombre = new Scanner(System.in);
        String nombrePersona = nombre.nextLine();

        System.out.println("Ingrese su fecha de nacimiento DD/MM/AAAA");
        Scanner fecha = new Scanner(System.in);
        String fechaPersona = nombre.nextLine();

        System.out.println("Ingrese su tipo de documento");
        Scanner documento = new Scanner(System.in);
        String documentoPersona = nombre.nextLine();

        System.out.println("Ingrese su numero de documento");
        Scanner nroDocumento = new Scanner(System.in);
        int nroDocumentoPerona = nombre.nextInt();

        //todo contactoview y aca se ejecutaria el método para cargar los contactos de la persona
    }
}
