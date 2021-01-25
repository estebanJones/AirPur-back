package fr.airpure.main.managers;

import org.springframework.stereotype.Component;

import fr.airpure.main.entities.Station;
import fr.airpure.main.utils.Lambert93;

@Component
public class MarkerManager {
	public MarkerManager() {
		// TODO Auto-generated constructor stub
	}
	
	public String formatteLatitudeForMarker(Station station) {
		String longitudeConverti = String.valueOf(Lambert93.convertLongitudeLambertToWgs(Double.valueOf(station.getLongitude()), Double.valueOf(station.getLatitude())));
		String latitudeConverti = String.valueOf(Lambert93.convertLatitudeLambertToWgs(Double.valueOf(station.getLongitude()), Double.valueOf(station.getLatitude())));
		// je dois garder 6 chiffres apres la virgule
		return this.latitudeeFormatte(latitudeConverti);
		
	}
	
	public String formatteLongitudeForMarker(Station station) {
		String longitudeConverti = String.valueOf(Lambert93.convertLongitudeLambertToWgs(Double.valueOf(station.getLongitude()), Double.valueOf(station.getLatitude())));
		String latitudeConverti = String.valueOf(Lambert93.convertLatitudeLambertToWgs(Double.valueOf(station.getLongitude()), Double.valueOf(station.getLatitude())));
		// je dois garder 6 chiffres apres la virgule
		return this.longitudeFormatte(longitudeConverti);
		
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
