package fr.airpure.main.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.response.DtoReleveStation;
import fr.airpure.main.dto.response.DtoStation;
import fr.airpure.main.entities.Polluant;
import fr.airpure.main.entities.Station;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.managers.MarkerManager;
import fr.airpure.main.services.PolluantService;
import fr.airpure.main.services.StationService;

@RestController
@RequestMapping("station")
public class StationController {
	private MarkerManager markerManager;
	private StationService stationService;
	private PolluantService polluantService;
	
	public StationController(MarkerManager markerManager, StationService stationService, PolluantService polluantService) {
		this.markerManager = markerManager;
		this.stationService = stationService;
		this.polluantService = polluantService;
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getStationsForMarkers() {
		List<Station> stations = this.stationService.getStations(); 
		List<DtoStation> stationsDto = stations.stream().map(station -> {
			
			String longitudeFormatte = this.markerManager.formatteLongitudeForMarker(station);
			String latitudeFormatte = this.markerManager.formatteLatitudeForMarker(station);

			station.setLatitude(latitudeFormatte);
			station.setLongitude(longitudeFormatte);
			return new DtoStation(station);
		}).collect(Collectors.toList());
		return ResponseEntity.ok(stationsDto);
	}
	
	@GetMapping("{idStation}")
	public ResponseEntity<?> getStationReleves(@PathVariable Integer idStation) throws NotFoundException {
		List<Polluant> polluants = this.polluantService.getDernierPolluantByStation(idStation);
		List<DtoReleveStation> dto = polluants.stream().map(polluant -> new DtoReleveStation(polluant)).collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
	
//	@GetMapping("{idStation}")
//	public ResponseEntity<?> getHistoriquePolluant(@PathVariable Integer idStation) throws NotFoundException {
//		List<Polluant> polluants = this.polluantService.getDernierPolluantByStation(idStation);
//		List<DtoReleveStation> dto = polluants.stream().map(polluant -> new DtoReleveStation(polluant)).collect(Collectors.toList());
//		return ResponseEntity.ok(dto);
//	}
}
