package fr.airpure.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class AirPureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirPureApplication.class, args);
	}

}
