package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.services.CommuneService;

@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private CommuneService communeService;
	
	public MainController() {
		super();
	}
	
	@GetMapping
	public void test() {
		this.communeService.test();
	}
}
