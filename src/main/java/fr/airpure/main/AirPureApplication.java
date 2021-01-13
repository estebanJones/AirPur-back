package fr.airpure.main;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import fr.airpure.main.controllers.ApiExtractController;
import fr.airpure.main.managers.ExtractAtmoApiManager;

import fr.airpure.main.managers.ExtractMeteoApiManager;

import fr.airpure.main.repositories.CommuneRepository;



/**
 * The Class AirPureApplication.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
@Transactional
@EnableScheduling
public class AirPureApplication {
	
	@Autowired
	ApiExtractController apiController;
	
	@Autowired
	private CommuneRepository repo;
	
	public AirPureApplication() {
	}
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AirPureApplication.class, args);
	}

	/**
	 * Permets de construire un RestTemplate qui utilise la bibliothèque JSON pour
	 * parse les Data de l'API en objets
	 * 
	 * @param builder
	 * @return
	 */
	@Bean
	public RestTemplate restTemplateMain(RestTemplateBuilder builder) {
		return builder.build();
	}

	/**
	 * Run le {@link restTemplateMain} et le logger.
	 * 
	 * @param restTemplate
	 * @return
	 * @throws Exception
	 */

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
		/**
		 * A but de test, lance une extraction au lancement pour avoir des données Pollution et Météo à chaque Run
		 */
		 
		 this.apiController.autoExtractPollution();
		this.apiController.autoExtractMeteo();
		};

	}


	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

}
