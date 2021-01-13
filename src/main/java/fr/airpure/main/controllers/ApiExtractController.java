package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import fr.airpure.main.managers.ExtractAtmoApiManager;
import fr.airpure.main.managers.ExtractMeteoApiManager;

@Controller
public class ApiExtractController {
	
	@Autowired
	ExtractMeteoApiManager extractMeteoManager;
	
	@Autowired
	ExtractAtmoApiManager extractAtmoMeteoManager;
	
	/**
	 * Lance un update
	 * @throws Exception
	 */
	@Scheduled(cron = "0 0 1 ? * *", zone = "Europe/Paris") // Tous les jours à 01H00 du matin, on met à jour les données Météo
	public void autoExtractMeteo() throws Exception {
	
		this.extractMeteoManager.extract();
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */	
	@Scheduled(cron = "0 31 * ? * *", zone = "Europe/Paris") // Toutes les heures, à XXH31, on met à jour les données Météo polutions
	public void autoExtractPollution() throws Exception {
	
		this.extractAtmoMeteoManager.extract();
	}
}
