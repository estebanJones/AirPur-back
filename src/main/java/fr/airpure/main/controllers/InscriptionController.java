package fr.airpure.main.controllers;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.RegisterDtoRequest;
import fr.airpure.main.dto.RegisterDtoResponse;
import fr.airpure.main.exceptions.FormulaireIncompletException;
import fr.airpure.main.exceptions.RequeteErreurException;
import fr.airpure.main.managers.InscriptionManager;
import fr.airpure.main.services.CheckerInscriptionService;



@RestController
@RequestMapping("accueil")
public class InscriptionController {
	private InscriptionManager inscriptionManager;
	
	public InscriptionController(InscriptionManager inscriptionManager, CheckerInscriptionService checkerInscriptionService) {
		this.inscriptionManager = inscriptionManager;
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
}
