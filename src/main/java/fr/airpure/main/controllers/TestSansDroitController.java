package fr.airpure.main.controllers;

import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.DtoTest;

@RestController
@RequestMapping("accueil")
public class TestSansDroitController {
	public TestSansDroitController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("inscription")
	public ResponseEntity getMessage() {
		Scanner sc = new Scanner(System.in);
		return ResponseEntity.ok(new DtoTest("SANS LES DROIT"));
		
	}
}
