package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dao.CommuneDAO;

@RestController
@RequestMapping("/accueil")
public class TestEntitesController {
	
	@Autowired
	private CommuneDAO communeDAO;
	
	public TestEntitesController() {
		super();
	}
	
	@GetMapping
	public void test() {
		
	}
}
