package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.airpure.main.managers.InitialDataManager;

@Controller
public class InitialDataController {

	
	@Autowired
	InitialDataManager initDataManager;
	
	public void initData() {	
		this.initDataManager.insertBaseDataForTest();
	}
}
