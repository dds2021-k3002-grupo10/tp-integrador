package com.disenio.config;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;

@SpringBootApplication
public class SwaggerConfig {
    public static void main(String[] args){

        SpringApplication.run(SwaggerConfig.class,args);
    }
}
