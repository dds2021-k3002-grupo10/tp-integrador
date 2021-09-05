package com.disenio.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class TareaProgramada {
    @Scheduled(cron = "*/200000 * * * * *")
public void  tarea(){
    System.out.println("recorre tarea cada 200000 seg tiempo");
}
}
