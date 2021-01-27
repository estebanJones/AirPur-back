package fr.airpure.main.services;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.airpure.main.entities.Polluant;
import fr.airpure.main.entities.Station;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
public class PolluantServiceTest {
	
	@Autowired
	private PolluantService polluantSerivce;
	
	@Autowired
	private StationService stationService;
	
	@Test
	void testCheckExistencePolluant() {
		
		LocalDateTime debutTest = LocalDateTime.now();
		LocalDateTime finTest = LocalDateTime.now();
		
		Polluant tempoPolluant = new Polluant("Test", 0, "uniteTest", debutTest, finTest);
		Station tempoStation = new Station("StationTest", "1", "1");
		tempoPolluant.setStation(tempoStation);
		
		boolean test = this.polluantSerivce.checkExistencePolluantBDD(tempoPolluant);
		
		assertFalse(test);
	}
	
	@Test
	void testCheckExistancePolluantBis() {
		
		LocalDateTime debutTest = LocalDateTime.now();
		LocalDateTime finTest = LocalDateTime.now();
		
		Polluant tempoPolluant = new Polluant("Test", 0, "uniteTest", debutTest, finTest);
		Station tempoStation = new Station("StationTest", "1", "1");
		tempoPolluant.setStation(tempoStation);
		
		this.stationService.save(tempoStation);
		this.polluantSerivce.save(tempoPolluant);
		
		boolean test = this.polluantSerivce.checkExistencePolluantBDD(tempoPolluant);
		
		this.polluantSerivce.deletePolluant(tempoPolluant);
		this.stationService.deleteStation(tempoStation);;
		
		assertTrue(test);
	}
	
	
}
