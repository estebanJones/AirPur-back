package fr.airpure.main.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.response.UtilisateurConnexionDtoResponse;
import fr.airpure.main.entities.Utilisateur;
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
	                .map(UtilisateurConnexionDtoResponse::new)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.badRequest().build());
	    }
	    
	/*
	 @GetMapping("utilisateur/{id}")
	 public void connecte() {
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();       
			String email = ((UserDetails) principal).getUsername();
			Optional<Utilisateur> utilisateur = this.utilisateurRepo.findByEmail(email);
			System.out.println(email);
	    }
	 
	 */
}
