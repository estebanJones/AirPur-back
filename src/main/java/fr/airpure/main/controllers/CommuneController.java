package fr.airpure.main.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.response.CommuneDtoResponse;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.exceptions.CommuneIntrouvableException;
import fr.airpure.main.services.CommuneService;

@RestController
@RequestMapping("commune")
public class CommuneController {

	@Autowired
	private CommuneService communeService;
	
	public CommuneController() {}
	
	/**
	 * Va chercher en BDD la commune en fonction de son ID et retourne une ResponseEntity vers le front
	 * @param idCommune
	 * @return La commune dont l'ID est renseignée en param encapsulé dans une ResponseEntity
	 * @throws CommuneIntrouvableException
	 */
	@GetMapping("id")
	public ResponseEntity<?> getCommuneById (@RequestParam int idCommune) throws CommuneIntrouvableException {
		
		Commune communeRecherche = this.communeService.getById(idCommune);
		CommuneDtoResponse dtoCommune = new CommuneDtoResponse(communeRecherche);
		
		return ResponseEntity.ok(dtoCommune);	
	}
	

	/**
	 * Va chercher en BDD la commune en fonction de son CODE INSEE et retourne une ResponseEntity vers le front
	 * @param codeInseeCommune
	 * @return La commune dont le CODE INSEE est renseignée en param encapsulé dans une ResponseEntity
	 * @throws CommuneIntrouvableException
	 */
	@GetMapping("insee")
	public ResponseEntity<?> getCommuneByInsee (@RequestParam String codeInseeCommune) throws CommuneIntrouvableException {
		
		Commune communeRecherche = this.communeService.findByCodeInsee(codeInseeCommune);
		
		CommuneDtoResponse dtoCommune = new CommuneDtoResponse(communeRecherche);
		
		return ResponseEntity.ok(dtoCommune);		
	}
	
	
}
