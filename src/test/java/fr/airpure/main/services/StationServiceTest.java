package fr.airpure.main.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.airpure.main.entities.Station;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
public class StationServiceTest {
	
	@Autowired
	private StationService stationService;
	
	@Test
	void testCheckExistenceStation() {
		Station tempoStation = new Station("StationTest", "1", "1");
		boolean test = this.stationService.checkExistenceStationBDD("StationTest");
		assertFalse(test);
	}
	
	@Test
	void testCheckExistenceStationBis() {
		Station tempoStation = new Station("StationTest", "1", "1");
		this.stationService.save(tempoStation);
		
		boolean test = this.stationService.checkExistenceStationBDD("StationTest");
		
		this.stationService.deleteStation(tempoStation);
		
		assertTrue(test);
	}
	
	
}
