package fr.airpure.main.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accueil")
public class TestEntitesController {
	
	
	public TestEntitesController() {
		super();
	}
	
	@GetMapping
	public void test() {
		
	}
}
