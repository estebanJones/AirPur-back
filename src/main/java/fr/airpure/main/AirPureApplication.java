package fr.airpure.main;

import javax.transaction.Transactional;

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

import fr.airpure.main.managers.ExtractAtmoApiManager;
import fr.airpure.main.managers.ExtractMeteoConceptManager;

/**
 * The Class AirPureApplication.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
@Transactional
@EnableScheduling
public class AirPureApplication {
	private ExtractAtmoApiManager extractAtmoApiManager;
	private ExtractMeteoConceptManager extractMeteoConceptManager;
	
	public AirPureApplication(ExtractAtmoApiManager extractAtmoApiManager, ExtractMeteoConceptManager extractMeteoConceptManager) {
		this.extractAtmoApiManager = extractAtmoApiManager;
		this.extractMeteoConceptManager = extractMeteoConceptManager;
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
	//@Scheduled(fixedRate=60*60*1000)
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
//			this.extractAtmoApiManager.extract(restTemplate);
//			this.extractMeteoConceptManager.run(restTemplate);
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
