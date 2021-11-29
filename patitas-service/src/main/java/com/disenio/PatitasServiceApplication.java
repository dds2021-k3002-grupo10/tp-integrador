package com.disenio;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mustache.MustacheEnvironmentCollector;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableScheduling
public class PatitasServiceApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PatitasServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(PatitasServiceApplication.class);
	}
	@Bean
	public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader templateLoader, Environment environment) {

		MustacheEnvironmentCollector collector = new MustacheEnvironmentCollector();
		collector.setEnvironment(environment);

		return Mustache.compiler()
				.defaultValue("Some Default Value")
				.withLoader(templateLoader)
				.withCollector(collector);

	}
}



