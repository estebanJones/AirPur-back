package fr.airpure.main.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.UtilisateurConnexionDto;
import fr.airpure.main.repositories.UtilisateurRepository;


@CrossOrigin
@RestController
public class AuthentificationController {
	private UtilisateurRepository utilisateurRepo;
	
	public AuthentificationController(UtilisateurRepository utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}
	
	 @GetMapping("/me")
	    public ResponseEntity<?> quiSuisJe() {
	        String email = SecurityContextHolder.getContext().getAuthentication().getName();
	        return this.utilisateurRepo.findByEmail(email)
	                .map(UtilisateurConnexionDto::new)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.badRequest().build());
	    }
}
