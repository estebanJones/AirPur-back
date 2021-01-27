package fr.airpure.main.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.MeteoIndicateur;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
class MeteoServiceTest{
	
	@Autowired
	private MeteoService meteoService;
	
	@Autowired 
	private CommuneService communeService;
	
	@Test
	void testCheckExistenceReleveMeteo() {
		
		Commune tempoCommune = new Commune("test", "99999", 1000, 1, 1);
		LocalDateTime tempoDate = LocalDateTime.now();
		MeteoIndicateur meteoIndicateurFalse =  new MeteoIndicateur(tempoDate , 2, 2.0 , 3, tempoCommune );
		boolean test = this.meteoService.checkExistenceReleveMeteo(meteoIndicateurFalse);
		
		assertFalse(test);
	}
	
	@Test
	void testCheckExistenceReleveMeteoBis() {
		
		
		Commune tempoCommune = this.communeService.getTop50Population().get(0);
		LocalDateTime tempoDate = LocalDateTime.now();
		MeteoIndicateur meteoIndicateurFalse =  new MeteoIndicateur(tempoDate , 2, 2.0 , 3, tempoCommune );
		
		this.meteoService.save(meteoIndicateurFalse);

		boolean test = this.meteoService.checkExistenceReleveMeteo(meteoIndicateurFalse);
		
		this.meteoService.deleteMeteo(meteoIndicateurFalse);
		
		assertTrue(test);
	}
	
}