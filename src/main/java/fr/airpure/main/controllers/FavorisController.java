package fr.airpure.main.controllers;
/*
 * Controller pour la gestions des favoris
 */

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.airpure.main.dto.FavorisDto;
import fr.airpure.main.dto.ResponseFavorisDto;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.exceptions.FavorisNotFoundException;
import fr.airpure.main.services.FavorisService;

@RequestMapping("accueil")
@RestController
@CrossOrigin
public class FavorisController {
	private FavorisService favorisService;

	public FavorisController(FavorisService favorisService) {
		super();
		this.favorisService = favorisService;
	}

	@PostMapping("/ajoutFavoris")
	public ResponseEntity<?> favoris(@RequestBody FavorisDto favorisDto, BindingResult requestValid) {
		if (!requestValid.hasErrors()) {

			this.favorisService.createAndSaveFavoris(favorisDto.getCommuneId(), favorisDto.getUtilisateurId(),favorisDto.getMeteo(), favorisDto.getAir(), favorisDto.getChoixDateDebut(),favorisDto.getChoixDateFin());
			return ResponseEntity.ok(new ResponseFavorisDto("Favoris bien ajouté"));
		} else {
			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}
	}

	@GetMapping("/mesFavoris")
	public List<Favoris> getMesFavoris() {
		return favorisService.getFavoris();
	}

	@GetMapping("/{id}")
	public Favoris getFavoris(@PathVariable("id") Integer id) throws FavorisNotFoundException {
		return this.favorisService.getFavoris(id);
	}

	@DeleteMapping("/{id}")
	public void deleteMonFavoris(@PathVariable("id") Integer id) {
		this.favorisService.deleteFavoris(id);
		;
	}

	@PutMapping("/{id}")
	public Favoris updateMaListeFavoris(@PathVariable("id") Integer id, @RequestBody Favoris favoris) {
		return this.favorisService.updateListeFavoris(id, favoris);
	}

}
