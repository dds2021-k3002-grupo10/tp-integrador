package services;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.entities.caracteristicas.Caracteristicas;
import domain.entities.caracteristicas.Comportamiento;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaracteristicaValorService {

    public void setCaracteristicaValor() throws IOException {

        Caracteristicas caracteristicas = new Caracteristicas();
        Comportamiento comportamiento = new Comportamiento();
        // List<Valores> valores = (List<Valores>) new Valores();

        //pregunta
        Scanner preguntaFaq = new Scanner(System.in);
        System.out.println("INGRESE PREGUNTA: ");
        String preguntaFaqEntrado = preguntaFaq.nextLine();

        //comportamiento de botones
        Scanner scComportamiento = new Scanner(System.in);
        System.out.println("INGRESE Comportamiento como CHECK O RBUTTON: ");
        String scComportamientoEntrado = scComportamiento.nextLine();
        if ("RBUTTON".equals(scComportamientoEntrado)) {
            comportamiento.setId(1L);
            comportamiento.setDescripcion(scComportamientoEntrado);
        } else {
            comportamiento.setId(2L);
            comportamiento.setDescripcion(scComportamientoEntrado);
        }

        //valores
//         Scanner scValores = new Scanner(System.in);
//        System.out.println("INGRESE Valores a su pregunta: ");
//        String scValoresEntrado = scValores.nextLine();


        caracteristicas.setId(1L);
        caracteristicas.setDescripcionFaq(preguntaFaqEntrado);
        caracteristicas.setComportamiento(comportamiento);
        caracteristicas.setIdOrganizacion(1L);
        //caracteristicas.setValores(valores);

        //abrir gson
        Gson gson = new Gson();
        String representacionJSON = gson.toJson(caracteristicas);
        //grabar fichero
        FileWriter fichero = new FileWriter("caracteristica999.json");
        fichero.write(representacionJSON);

        fichero.close();

    }

    public List<Caracteristicas> getCaracteristicaValor() {
        //getString json
        String json = getStringJson();
        //convertir contenido a objeto
        //List<Caracteristicas> caracteristicas = gson.fromJson(json, Caracteristicas.class);
        Gson gson = new Gson();
        List<Caracteristicas> caracteristicasList = gson.fromJson(json, new TypeToken<List<Caracteristicas>>() {
        }.getType());
        return caracteristicasList;
    }

    private String getStringJson() {
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("caracteristica.json"));

            String linea = "";
            while ((linea = br.readLine()) != null) {
                json += linea;

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaracteristicaValorService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CaracteristicaValorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

}
