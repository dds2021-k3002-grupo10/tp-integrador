package scheduler;

import domain.Persona;
import jdk.nashorn.internal.objects.NativeArray;
import org.quartz.*;

import java.util.ArrayList;
import java.util.List;

public class TaskRecomendacionesMascotaJob implements Job {
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(TaskRecomendacionesMascotaJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // JobDetail
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        //System.out.println("hola Guille - Dani ");
       // accionEviarRecomendacion(nuevaListaPersonasAdoptante());

    }


    /*private List<Persona> nuevaListaPersonasAdoptante() {
        Persona personasAdptante = new PersonasAdptante();
        List<Persona> listaPersonasAdoptante =  personasAdoptante.getRecuperaPersona();
        return listaPersonasAdoptante;
    }*/

  /*private void accionEviarRecomendacion(List<Persona> nuevaListaPersonasAdoptante) {
        if (nuevaListaPersonasAdoptante != null) {
            for (Persona persona : nuevaListaPersonasAdoptante) {
                // metodo realizar chequeo que mecheen con mascota
                  boolean respuesta = coinsidenciaMascotas(persona);
                if(respuesta){
                    try {
                        persona.notificar();
                    } catch (Exception exc) {
                        LOGGER.debug("accionEviarRecomendacion", exc);
                    }
                }
            }
        }
    }*/
}
