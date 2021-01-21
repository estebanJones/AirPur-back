package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import fr.airpure.main.managers.ExtractAtmoApiManager;
import fr.airpure.main.managers.ExtractMeteoApiManager;


/**
 * Controller qui gère l'extraction automatiques des informations des API suivantes :
 * - API ATMO Occitanie pour les données de polutions 1 fois par heures
 * - API Meteo Concept pour les données météorologiques 1 fois par jour
 * @author Exost
 *
 */
@Controller
public class ApiExtractController {
	
	@Autowired
	ExtractMeteoApiManager extractMeteoManager;
	
	@Autowired
	ExtractAtmoApiManager extractAtmoMeteoManager;
	
	/**
	 * Extrait les nouvelles données météorologiques.
	 * S'active automatiquement une fois par jours à 01H00 chaque jour.
	 * @throws Exception
	 */
	@Scheduled(cron = "0 0 1 ? * *", zone = "Europe/Paris") // Tous les jours à 01H00 du matin, on met à jour les données Météo
	public void autoExtractMeteo() throws Exception {
	
		this.extractMeteoManager.extract();
		
	}
	
	/**
	 * Extrait les nouvelles données de polutions.
	 * S'active automatiquement une fois par heure, à XXh31 chaque heure
	 * @throws Exception
	 */	
	@Scheduled(cron = "0 31 * ? * *", zone = "Europe/Paris") // Toutes les heures, à XXH31, on met à jour les données Météo polutions
	public void autoExtractPollution() throws Exception {
	
		this.extractAtmoMeteoManager.extract();
	}
}
