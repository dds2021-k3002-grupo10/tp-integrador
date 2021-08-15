package scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class TaskQuartz {

    private static Log logger = LogFactory.getLog(TaskQuartz.class);
private int semana = 168;
    public static void main(String[] args) {

        try {
            // crear una instancia
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            // instanciar el planificador
            scheduler.start();

            // prueba cada 5 segundos
            JobDetail jobDetail1 = newJob(TaskRecomendacionesMascotaJob.class).withIdentity("job1", "group").build();
            //jobDetail1.getJobDataMap().put("CONTENT", "voy a llamar un metodo");
            Trigger trigger1 = newTrigger().withIdentity("trigger1", "group")
                    .startNow()
                    .withSchedule(simpleSchedule()
                                .withIntervalInSeconds(5)
                            //.withIntervalInHours(semana)
                            .repeatForever())
                    .build();

            scheduler.scheduleJob(jobDetail1, trigger1);







        } catch (SchedulerException e) {
            logger.error(e);
        }
    }
    }



