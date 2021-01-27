package fr.airpure.main.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.exceptions.echange.ForbiddenException;
import fr.airpure.main.dto.UtilisateurWithPasswordDto;
import fr.airpure.main.dto.UpdatateDtoResponse;
import fr.airpure.main.dto.UpdateDto;
import fr.airpure.main.dto.UtilisateurDto;
import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.dto.response.RegisterDtoResponse;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.exceptions.FormulaireIncompletException;
import fr.airpure.main.exceptions.RequeteErreurException;
import fr.airpure.main.managers.InscriptionManager;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.services.CheckerInscriptionService;
import fr.airpure.main.services.UtilisateurService;
import fr.airpure.main.services.UtilisateurUtils;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;

@RestController
@RequestMapping("accueil")
public class InscriptionController {
	private InscriptionManager inscriptionManager;

	public InscriptionController(InscriptionManager inscriptionManager,
			CheckerInscriptionService checkerInscriptionService) {
		this.inscriptionManager = inscriptionManager;
	}

	@PostMapping("register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDtoRequest dtoRequest, BindingResult resValid)
			throws ParseException {
		if (!resValid.hasErrors()) {
			if (this.inscriptionManager.controleInscriptionProprietes(dtoRequest)) {
				RegisterDtoResponse response = this.inscriptionManager.inscription(dtoRequest);
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.badRequest()
						.body(new FormulaireIncompletException("Le formulaire est incomplet."));
			}
		} else {
			return ResponseEntity.badRequest().body(new RequeteErreurException("Une erreur est survenue"));
		}
	}

	
}
