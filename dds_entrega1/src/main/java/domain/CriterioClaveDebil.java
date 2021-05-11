package domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriterioClaveDebil implements CriterioValidacionClave{
    List<String> clavesInvalidas = new ArrayList<String>();

    public void levantarContrasenasDebiles(){
        try(FileReader fr = new FileReader("clavesDebiles.txt");
                BufferedReader br = new BufferedReader(fr))
        {
            String linea;

            while((linea = br.readLine()) != null)
                this.clavesInvalidas.add(linea);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Boolean esClaveValida(String clave){

        this.levantarContrasenasDebiles();

        return !clavesInvalidas.contains(clave.toLowerCase());
    }
}
