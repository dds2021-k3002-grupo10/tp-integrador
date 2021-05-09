package domain;

import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {

        System.out.println("Ingrese usuario:");
        Scanner usuario = new Scanner(System.in);
        String usuarioNuevo = usuario.nextLine();

        System.out.println("Ingrese contraseña (Debe ser mayor a 8 caracteres y " +
                "contener una mayuscula, una minuscula y un numero");
        Scanner contrasenia = new Scanner(System.in);
        String contraseniaNueva = contrasenia.nextLine();

        Usuario user1 = new Usuario(usuarioNuevo, contraseniaNueva);

        CriterioRegex validador = new CriterioRegex();
        CriterioClaveDebil listaDeClavesDebiles = new CriterioClaveDebil();
        listaDeClavesDebiles.levantarContrasenasDebiles();
        validador.criteriosRegex();
        Boolean verificar = validador.esClaveValida(user1.getContrasenia());

        Boolean claveDebil = listaDeClavesDebiles.esClaveValida(user1.getContrasenia());

        if(verificar && claveDebil)
            System.out.println("Su usuario fue creado");
        else
            System.out.println("Su contraseña no cumple con los requisitos");


    }
 }
