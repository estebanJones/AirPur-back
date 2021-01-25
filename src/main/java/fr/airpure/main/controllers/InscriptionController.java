package fr.airpure.main.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.dto.response.RegisterDtoResponse;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.exceptions.FavorisNotFoundException;
import fr.airpure.main.exceptions.FormulaireIncompletException;
import fr.airpure.main.exceptions.RequeteErreurException;
import fr.airpure.main.managers.InscriptionManager;
import fr.airpure.main.services.CheckerInscriptionService;
import fr.airpure.main.services.UtilisateurService;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;


@RestController
@RequestMapping("accueil")
public class InscriptionController {
	private InscriptionManager inscriptionManager;
	// Pour le get, put et delete
	private UtilisateurService utilisateurService;
	
	public InscriptionController(InscriptionManager inscriptionManager, CheckerInscriptionService checkerInscriptionService, UtilisateurService utilisateurService) {
		this.inscriptionManager = inscriptionManager;
		this.utilisateurService = utilisateurService;
	}
	
	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDtoRequest dtoRequest, BindingResult resValid) throws ParseException {
		if(!resValid.hasErrors()) {
			if(this.inscriptionManager.controleInscriptionProprietes(dtoRequest)) {
				RegisterDtoResponse response = this.inscriptionManager.inscription(dtoRequest);
				return ResponseEntity.ok(response);
			}
			else {
				return ResponseEntity.badRequest().body(new FormulaireIncompletException("Le formulaire est incomplet."));
			}
		} else {
			return ResponseEntity.badRequest().body(new RequeteErreurException("Une erreur est survenue"));
		}
	}
	
	//Methode pour avoir la liste des utilisateurs
	
	@GetMapping("/utilisateurs")
	public List<Utilisateur> getListeUtilisateurs() {
		return utilisateurService.getAllUtilisateurs();
	}
	// Methode avoir un utilisateur
	
	@GetMapping("utilisateur/{id}")
	public Utilisateur getUnUtilisateur(@PathVariable("id") Integer id) throws UtilisateurNotFoundException {
		return this.utilisateurService.getUtilisateur(id);
	}
	
	// Methode avoir supprimer un utilisateur
	@DeleteMapping("delete/{id}")
	public void deleteUnUtilisateur(@PathVariable("id") Integer id) {
		this.utilisateurService.deleteUtilisateur(id);
	}
	
	//Methode update données de l'utilsateur
	@PutMapping("update/{id}")
	public Utilisateur updateUtilisateur(@PathVariable("id") Integer id, @RequestBody Utilisateur utilisateur) {
		return this.utilisateurService.updateUtilisateur(id, utilisateur);
	}

	
}
