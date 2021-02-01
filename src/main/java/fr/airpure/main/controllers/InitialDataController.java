package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.airpure.main.managers.InitialDataManager;

@Controller
public class InitialDataController {

	
	@Autowired
	InitialDataManager initDataManager;
	
	/**
	 * A pour vocation de faciliter/raccourir l'initialisation de la BDD lors du lancement
	 * - Ici, supprime toutes les communes en dehors de l'Occitanie
	 */
	public void initData() {	
		//this.initDataManager.insertBaseDataForTest();
		this.initDataManager.cleanInitialBDD();
	}
}
