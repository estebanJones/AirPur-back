package fr.airpure.main.managers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.airpure.main.autoGenerated.ApiMeteoResponse;
import fr.airpure.main.autoGenerated.Forecast;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.services.CommuneService;
import fr.airpure.main.services.MeteoService;
import fr.airpure.main.utils.DateUtils;

@Service
public class ExtractMeteoConceptManager {
	private static final Logger LOG = LoggerFactory.getLogger(ExtractAtmoApiManager.class);
	private static final String TOKEN = "8c7d59aba8b61f1963ff816bd5cc05abbd35ee37cbe0848b2862a18a46973402";
	private MeteoService meteoService;
	private CommuneService communeService;
	private DateUtils dateUtils;
	
	public ExtractMeteoConceptManager(CommuneService communeService, MeteoService meteoService, DateUtils dateUtils) {
		this.communeService = communeService;
		this.meteoService = meteoService;
		this.dateUtils = dateUtils;
	}
	
	public void run(RestTemplate restTemplate) {
		// RECUPERER TOP 50 VILLE
		LOG.info("DEBUT DU PROGRAMME");
		List<Commune> communesList = this.communeService.getTop50Population();
		this.extract(restTemplate, communesList);
		LOG.info("FIN DU PROGRAMME");
	}
	
	public void extract(RestTemplate restTemplate, List<Commune> communesList) {
		// PARCOURIRE LE TOP 50
		for(Commune commune : communesList) {
			LOG.info("TRAITEMENT " + commune.getNomCommune());
			// POUR CHAQUE COMMUNE PREND LE CODE INSEE ET LE METTRE EN PARAM DE LA REQUETE
			String url = "https://api.meteo-concept.com/api/forecast/nextHours?token=" + TOKEN + "&insee=" + commune.getCodeInseeCommune();
			ApiMeteoResponse meteoListe = restTemplate.getForObject(url, ApiMeteoResponse.class);
			for(Forecast forecast : meteoListe.getForecast()) {
				LOG.info("CREATION FORECAST");
				LocalDateTime date = this.parseAndConverteForcaste(forecast.getDatetime());
				// CREER UN OBJET METEO INDICATEUR
				// LE LIER A UNE COMMUNE
				MeteoIndicateur meteoIndicateur = new MeteoIndicateur(date, forecast.getDirwind10m(), forecast.getRr10(), forecast.getTsoil2(), commune);
				// LE PERSISTER EN BASE
				this.meteoService.save(meteoIndicateur);
				LOG.info("FORECAST CREE ET PERSISTER");
			}
		}
	}
	/**
	 * A MODIFIER
	 */
	public LocalDateTime parseAndConverteForcaste(String dateAtraiter) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		String date = this.dateUtils.parseDate(dateAtraiter);
		String newDate = date.replace("T", " ");
		return LocalDateTime.parse(newDate, formatter);
	}

}
