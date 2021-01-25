package fr.airpure.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.transaction.Transactional;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import fr.airpure.main.controllers.ApiExtractController;
import fr.airpure.main.controllers.InitialDataController;
import fr.airpure.main.managers.BaseDataManager;
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
	InitialDataController initDataController;


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
//		this.initDataController.initData();	
//		this.apiController.autoExtractPollution();
//		this.apiController.autoExtractMeteo();

<<<<<<< HEAD
			/* try {

				/*String url = "jdbc:h2:mem:db" ; // database specific url.

				Properties properties = new Properties();
				properties.put("user", "root");
				properties.put("password", "");

				Connection connection = DriverManager.getConnection(url, properties);

				File file = new File("C:\\Users\\Exost\\git\\AirPur-back\\src\\main\\resources\\myScript.sql");
				if (!file.exists()) {
					throw new FileNotFoundException("can't init mysql with sql script file is not exists");
				}

				FileSystemResource rc = new FileSystemResource(file);
				EncodedResource encodeRes = new EncodedResource(rc, "GBK");
				//ScriptUtils.executeSqlScript(connection, encodeRes);
				// SqlLog.info("windchat init mysql database with sql-script finish");

				// file.delete();
			} catch (Exception e) {
				throw new SQLException(e);
			} */

			/**
			 * A but de test, lance une extraction au lancement pour avoir des données
			 * Pollution et Météo à chaque Run
			 */
			// à commenter si on a déja les données en base
			// this.initDataController.initData();
			//this.apiController.autoExtractPollution();
			//this.apiController.autoExtractMeteo();
=======
>>>>>>> 2f10849d8801bfbe463627969d334fc5c7f211af
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
