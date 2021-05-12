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

        ValidadorDeClave validador = new ValidadorDeClave();

        while(!validador.esClaveValida(contraseniaNueva)){
            System.out.println("Su contraseña no cumple con los requisitos, vuelva a ingresarla");
            System.out.println("Ingrese contraseña (Debe ser mayor a 8 caracteres y " +
                    "contener una mayuscula, una minuscula y un numero)");
            contrasenia = new Scanner(System.in);
            contraseniaNueva = contrasenia.nextLine();


        }

        if(validador.esClaveValida(contraseniaNueva)){
            Usuario user1 = new Usuario(usuarioNuevo, contraseniaNueva);
            System.out.println("Su usuario fue creado");
        }
/**
        CriterioRegex validador = new CriterioRegex();
        CriterioClaveDebil listaDeClavesDebiles = new CriterioClaveDebil();


        Boolean cumpleRequisitos = validador.esClaveValida(contraseniaNueva);

        Boolean claveFuerte = listaDeClavesDebiles.esClaveValida(contraseniaNueva);



        while(!cumpleRequisitos || !claveFuerte){
            System.out.println("Su contraseña no cumple con los requisitos, vuelva a ingresarla");
            System.out.println("Ingrese contraseña (Debe ser mayor a 8 caracteres y " +
                    "contener una mayuscula, una minuscula y un numero)");
            contrasenia = new Scanner(System.in);
            contraseniaNueva = contrasenia.nextLine();

            cumpleRequisitos = validador.esClaveValida(contraseniaNueva);

            claveFuerte = listaDeClavesDebiles.esClaveValida(contraseniaNueva);
        }

        if(cumpleRequisitos && claveFuerte) {
            Usuario user1 = new Usuario(usuarioNuevo, contraseniaNueva);
            System.out.println("Su usuario fue creado");
        }
**/
    }
 }
