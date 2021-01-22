package fr.airpure.main.controllers;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.response.DtoStation;
import fr.airpure.main.entities.Station;
import fr.airpure.main.services.StationService;
import fr.airpure.main.utils.Lambert93;

@RestController
@RequestMapping("station")
public class StationController {
	private StationService stationService;
	public StationController(StationService stationService) {
		this.stationService = stationService;
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getStations() {
		// récupération des coordonnées
	    int latitude= 6176047;
	    int longitude= 692077;    

	    double y = Lambert93.convertLatitudeLambertToWgs(longitude, latitude);
	    double x = Lambert93.convertLongitudeLambertToWgs(longitude, latitude);
		List<Station> stations = this.stationService.getStations(); 
		List<DtoStation> stationsDto = stations.stream().map(station -> {
			
			String longitudeConverti = String.valueOf(Lambert93.convertLongitudeLambertToWgs(Double.valueOf(station.getLongitude()), Double.valueOf(station.getLatitude())));
			String latitudeConverti = String.valueOf(Lambert93.convertLatitudeLambertToWgs(Double.valueOf(station.getLongitude()), Double.valueOf(station.getLatitude())));
			// je dois garder 6 chiffres apres la virgule
			String longitudeFormatte = this.longitudeFormatte(longitudeConverti);
			String latitudeFormatte = this.latitudeeFormatte(latitudeConverti);

			station.setLatitude(latitudeFormatte);
			station.setLongitude(longitudeFormatte);
			return new DtoStation(station);
		}).collect(Collectors.toList());
		return ResponseEntity.ok(stationsDto);
	}
	public Integer getIndexPoint(String valeur) {
		return valeur.indexOf(".");
	}
	public String longitudeFormatte(String longitudeConverti) {
		int indexDuPoint = this.getIndexPoint(longitudeConverti);
		int indexFin = indexDuPoint + 7;
		return longitudeConverti.substring(0, indexFin);
		
	}
	
	public String latitudeeFormatte(String latitudeConverti) {
		int indexDuPoint = this.getIndexPoint(latitudeConverti);
		int indexFin = indexDuPoint + 7;
		return latitudeConverti.substring(0, indexFin);
	}
}
