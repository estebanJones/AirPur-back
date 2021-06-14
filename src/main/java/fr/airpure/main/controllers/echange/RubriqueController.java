package fr.airpure.main.controllers.echange;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import fr.airpure.main.dto.UpdatateDtoResponse;
import fr.airpure.main.dto.UtilisateurDto;
import fr.airpure.main.dto.UtilisateurWithPasswordDto;
import fr.airpure.main.dto.echange.RubriqueDto;
import fr.airpure.main.dto.echange.RubriqueDtoWithId;
import fr.airpure.main.dto.response.FavorisDtoResponse;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;
import fr.airpure.main.exceptions.echange.EchangeNotFoundException;
import fr.airpure.main.services.UtilisateurService;
import fr.airpure.main.services.echange.RubriqueService;

@RestController
@RequestMapping("/accueil/rubriques")
public class RubriqueController {
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private RubriqueService rubriqueService;
	@Autowired
	private ModelMapper modelMapper;

	/*
	 * Méthodes de Conversion de Entité -> Dto et Dto -> Entity Trouver une solution
	 * et le sortir du controller Interface fonctionnelle à cause du ::
	 */
	private RubriqueDtoWithId convertToDto(Rubrique rubrique) {
		RubriqueDtoWithId rubriqueDto = modelMapper.map(rubrique, RubriqueDtoWithId.class);
		return rubriqueDto;
	}

	private Rubrique convertToEntity(RubriqueDtoWithId rubriqueDtoWithId) throws EchangeNotFoundException {
		Rubrique rubrique = modelMapper.map(rubriqueDtoWithId, Rubrique.class);
		if (rubriqueDtoWithId.getId() != null) {
			Rubrique ancienRubrique = rubriqueService.getRubrique(rubriqueDtoWithId.getId());
		}
		return rubrique;
	}

	/*
	 * Entity-Dto Utils de Utilisateur
	 */
	private UtilisateurDto convertToDto(Utilisateur utilisateur) {
		UtilisateurDto utilisateurDto = modelMapper.map(utilisateur, UtilisateurDto.class);
		return utilisateurDto;
	}

	private Utilisateur convertToEntity(UtilisateurWithPasswordDto passwordDto) throws UtilisateurNotFoundException {
		Utilisateur utilisateur = modelMapper.map(passwordDto, Utilisateur.class);
		if (passwordDto.getId() != null) {
			Utilisateur ancienUtilisateur = utilisateurService.getUtilisateur(passwordDto.getId());
		}
		return utilisateur;
	}

	/*
	 * API de POST de rubrique
	 */

	@PostMapping
	public ResponseEntity<?> rubrique(@RequestBody RubriqueDto rubriqueDto, BindingResult requestValid) {
		if (!requestValid.hasErrors()) {
			this.rubriqueService.createAndSaveRubrique(rubriqueDto.getUtilisateurId(), rubriqueDto.getTitle(),
					rubriqueDto.getDescription(), rubriqueDto.getContent(), rubriqueDto.getPostedOn());
			return ResponseEntity.ok(new FavorisDtoResponse("Rubrique bien ajouté"));
		} else {
			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}
	}

	/*
	 * API de GET de la liste de rubrique total
	 */
	@GetMapping
	@ResponseBody
	public List<RubriqueDtoWithId> getListeRubrique() {
		List<Rubrique> rubriques = rubriqueService.getTousLesRubriques();
		return rubriques.stream().map(this::convertToDto).collect(Collectors.toList());

	}
	/*
	 * API de GET la liste des rubriques de l'utilisateur
	 */

	@GetMapping("{utilisateurId}")
	public List<RubriqueDtoWithId> findByUtilisateur(@PathVariable Integer utilisateurId) {
		List<Rubrique> rubrique = rubriqueService.getMesRubriques(utilisateurId);
		return rubrique.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	/*
	 * API de UPDATE de rubrique
	 */
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@RequestBody RubriqueDtoWithId rubriqueDtoWithId) throws EchangeNotFoundException {
		Rubrique rubrique = convertToEntity(rubriqueDtoWithId);
		rubriqueService.updateRubrique(rubrique);
		UpdatateDtoResponse responseDto = new UpdatateDtoResponse("Rubrique mis à jour");
		return ResponseEntity.ok(responseDto);
	}

	/*
	 * API de suppresion
	 */
	@DeleteMapping("{id}")
	public void deleteUnRubrique(@PathVariable("id") Integer id) {
		this.rubriqueService.deleteRurbique(id);
	}

}
