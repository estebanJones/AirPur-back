package fr.airpure.main.controllers;

import java.security.Principal;
import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.DtoTest;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;

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


