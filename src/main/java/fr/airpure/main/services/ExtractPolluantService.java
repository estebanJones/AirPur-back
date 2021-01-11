package fr.airpure.main.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.airpure.main.autoGenerated.Feature;
import fr.airpure.main.autoGenerated.IndicateurPollutionAir;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Polluant;
import fr.airpure.main.entities.Station;
import fr.airpure.main.exceptions.echange.NotFoundException;

@Service
public class ExtractPolluantService {
	private static final Logger LOG = LoggerFactory.getLogger(ExtractPolluantService.class);
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	private static final String PATH_ATMO = "https://opendata.arcgis.com/datasets/4a648b54876f485e92f22e2ad5a5da32_0.geojson";
	
	
	private CommuneService communeService;
	private StationService stationService;
	private PolluantService polluantService;
	
	public ExtractPolluantService(CommuneService communeService, StationService stationService,  PolluantService polluantService) {
		this.communeService = communeService;
		this.stationService = stationService;
		this.polluantService = polluantService;
	}
	
	
	public void extract(RestTemplate restTemplate) {
			IndicateurPollutionAir qualiteAirListe = restTemplate.getForObject(PATH_ATMO, IndicateurPollutionAir.class);
			List<Feature> maListe = qualiteAirListe.getFeatures();
			
			long start = System.currentTimeMillis();
			LOG.info("Debut de la lecture du fichier JSON");
			for (Feature m : maListe) {
				
				String dateDebut = this.parseDate(m.getProperties().getDateDebut());
				String dateFin = this.parseDate(m.getProperties().getDateFin());
				LOG.info("Formattage des dates terminés");
				try {
					// POUR CHAQUE LIGNE JE CREAIS UN POLLUANT ET UNE STATION
					// JE CHERCHE LA REGION PAR CODE INSEE DE LA COMMUNE TRAITEE
					// Region region = this.regionService.findByCodeInsee(String.valueOf(m.getProperties().getInseeCom()));
					String codeInsee = String.valueOf(m.getProperties().getInseeCom());
					
					Commune commune = this.communeService.findByCodeInsee(codeInsee);
					
					// JE CONVERTIS LES DATE
					LocalDateTime dateDebutFinale = LocalDateTime.parse(dateDebut, FORMATTER);
					LocalDateTime dateFinFinale = LocalDateTime.parse(dateFin, FORMATTER);		
					
					// CREATION STATION
					Station station = this.stationService.creer(m);
					
					// JOINTURE STATION COMMUNE
					station.setCommune(commune);
					
					//PERSIST STATION
					Station stationDataBase = this.stationService.save(station);
					LOG.info("Station créée et persistées");
					// CREATION POLLUANT
					Polluant polluant = this.polluantService.creer(m, dateDebutFinale, dateFinFinale);
					// JOINTURE POLLUANT STATION
					polluant.setStation(stationDataBase);
					
					// PERSIST POLLUANT
					this.polluantService.save(polluant);
					LOG.info("Polluant créé et persistés");
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
		
			long tempsExecution = System.currentTimeMillis() - start;
			LOG.info("Fin du programme");
			LOG.info("--------------------------------------");
			LOG.info("Temps d'execution " + tempsExecution);
	}
	
	
	
	/**
	 * LA DATE ARRIVE AVEC LES MILLISECONDES AU FORMAT 
	 * 2021/01/10 21:00:00+00
	 * JE LA VEUX EN 2021/01/10 21:00:00
	 * @param date
	 * @return
	 */
	public String parseDate(String date) {
		Integer indexFin = date.indexOf("+");
		return date.substring(0, indexFin);
	}
	
}