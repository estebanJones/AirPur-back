package fr.airpure.main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import fr.airpure.main.TrainREST.Quote;
import fr.airpure.main.autoGenerated.IndicateurPollutionAir;
import fr.airpure.main.autoGenerated.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import fr.airpure.main.autoGenerated.Feature;

/**
 * The Class AirPureApplication.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class AirPureApplication {

	/**
	 * Logger pour afficher les infos de l'extractions de l'API ATMO
	 */
	private static final Logger log = LoggerFactory.getLogger(AirPureApplication.class);

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
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			IndicateurPollutionAir obj = restTemplate.getForObject(
					"https://opendata.arcgis.com/datasets/4a648b54876f485e92f22e2ad5a5da32_0.geojson",
					IndicateurPollutionAir.class);
			// log.info("mouss" + obj.toString());
			// String json= obj.toString();

			// System.out.println("Md" + obj.getType());
			/*
			System.out.println(obj.getClass());
			System.out.println(obj.getFeatures());
			List<Feature> maListe = obj.getFeatures();
			System.out.println("----------------------------");
			System.out.println(maListe.size());
			for (Feature m : maListe) {
				System.out.println(m.getProperties().getxL93());
				System.out.println(m.getProperties().getyL93());
				System.out.println(m.getProperties().getInseeCom());
				System.out.println(m.getProperties().getNomCom());
			}
			
			// System.out.println("new affichage" + obj.getType());
			// System.out.println(obj.getFeatures().toString());
			// Map<String, String> map = mapper.readValue(json, Map.class);
			 * 
			 
*/	
			LireEnBase();
			
			String url ="jdbc:mysql://localhost:3308/airpur";
			String login	="root";
			String password ="";
			
			Connection cn = null; java.sql.Statement st = null; ResultSet rs = null;
			try	{
				Class.forName("com.mysql.cj.jdbc.Driver");
				//
				cn = DriverManager.getConnection(url, login, password);
				
				/////////////////////////////////////
				//
				st = cn.createStatement();

				String sql = "SELECT C2.id FROM commune as C2 \r\n"
						+ "INNER JOIN departement ON C2.departement_id = departement.id\r\n"
						+ "INNER JOIN region ON region.id = departement.region_id\r\n"
						+ "WHERE region.id = 5";
				
				//rs = st.executeQuery(sql);
				
				System.out.println(obj.getClass());
				System.out.println(obj.getFeatures());
				List<Feature> maListe = obj.getFeatures();
				System.out.println("----------------------------");
				System.out.println(maListe.size());
				maListe.stream().map(e -> e.getProperties().getxL93()).distinct().forEach(i -> System.out.println(i));
					for (Feature m : maListe) {
						System.out.println(m.getProperties().getxL93());
						System.out.println(m.getProperties().getyL93());
						System.out.println(m.getProperties().getInseeCom());
						System.out.println(m.getProperties().getNomCom());
							//insertion sql Latitude
						String sql2 = "UPDATE commune as C" + " SET C.latitude = '"+ m.getProperties().getxL93() + "' " + " WHERE C.id IN ( "+ sql + ");";
						st.executeUpdate(sql2);
						//insertion sql Longitude
						//String sql3 = "UPDATE commune " + " SET longitude = '"+ m.getProperties().getyL93() + "' " + " WHERE code_insee='"+ m.getProperties().getInseeCom() + "';";
						//st.executeUpdate(sql3);	
						
						//String optiUpdate =  "UPDATE commune " + " SET latitude = '"+ m.getProperties().getxL93() + "' " + " WHERE commune.id IN' "+ sql; 
					}
				
				
		///////////////////////		
			}
			catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					cn.close();
					st.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
	}

	public static void LireEnBase() {
		
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
