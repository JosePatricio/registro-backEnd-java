package com.sukasa;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sukasa.infraestructure.models.BeneficioModel;
import com.sukasa.infraestructure.service.BeneficioService;
import com.sukasa.domain.events.domain.ClienteCreatedDomainEventHandler;
import com.sukasa.infraestructure.Utiles.*;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.Registry;
import io.jkratz.mediator.spring.SpringMediator;
import io.jkratz.mediator.spring.SpringRegistry;

@SpringBootApplication
public class SukasaApplication {

	private final ApplicationContext applicationContext;
    private final static Logger logger = LoggerFactory.getLogger(SukasaApplication.class);

	@Autowired
	public SukasaApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public Registry registry() {
		return new SpringRegistry(applicationContext);
	}

	@Bean
	public Mediator mediator(Registry registry) {
		return new SpringMediator(registry);
	}



	
	
	@Bean
	CommandLineRunner runner(BeneficioService service){
		return args -> {

			try {
				logger.info("Cargando archivos JSON y XML... ");
				Util util=new Util();
				var TH_DATA=util.leerArchivoXML();
				var SK_DATA=util.leerArchivoJSON();
			   
				service.deleteAll();
				service.save(TH_DATA);
				service.save(SK_DATA);
				logger.info("Datos cargados exitósamente.");
			} catch (Exception e){
				System.out.println("Unable to save  " + e.getMessage());
			}
		};
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SukasaApplication.class, args);
	}

}
