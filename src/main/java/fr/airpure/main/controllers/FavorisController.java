package fr.airpure.main.controllers;
/*
 * Controller pour la gestions des favoris
 */

import java.util.ArrayList;
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

import fr.airpure.main.dto.request.FavorisDtoRequest;
import fr.airpure.main.dto.response.DtoFavoris;
import fr.airpure.main.dto.response.FavorisDtoResponse;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.exceptions.FavorisNotFoundException;
import fr.airpure.main.services.FavorisService;


@RequestMapping("favoris")
@RestController
@CrossOrigin
public class FavorisController {
	private FavorisService favorisService;

	public FavorisController(FavorisService favorisService) {
		super();
		this.favorisService = favorisService;
	}
	
	@PostMapping("create")
	public ResponseEntity<?> favoris (@RequestBody FavorisDtoRequest favorisDto, BindingResult requestValid) {
		if (!requestValid.hasErrors()) {
			this.favorisService.createAndSaveFavoris(favorisDto.getCommuneId(), favorisDto.getUtilisateurId(), favorisDto.getMeteo(), favorisDto.getAir(), favorisDto.getChoixDateDebut(), favorisDto.getChoixDateFin());
			return ResponseEntity.ok(new FavorisDtoResponse("Favoris bien ajouté"));
		}
		else {
			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}
	}


	@GetMapping("releves/liste/{idUtilisateur}")
	public ResponseEntity<?> getListeFavoris(@PathVariable("idUtilisateur") Integer idUtilisateur) {
		List<DtoFavoris> dtoFavoris = this.favorisService.getFavorisByUtilisateur(idUtilisateur);
		return ResponseEntity.ok(dtoFavoris);
	}
/*
	@GetMapping("/mesFavoris")
	public List<Favoris> getListeFavoris() {
		return favorisService.getTousLesFavoris();

	}
	*/

	@GetMapping("{id}")
	public Favoris getUnFavoris(@PathVariable("id") Integer id) throws FavorisNotFoundException {
		return this.favorisService.getFavoris(id);
	}

	@DeleteMapping("delete/{id}")
	public void deleteMonFavoris(@PathVariable("id") Integer id) {
		this.favorisService.deleteFavoris(id);
		;
	}

	@PutMapping("update/{id}")
	public Favoris updateMaListeFavoris(@PathVariable("id") Integer id, @RequestBody Favoris favoris) {
		return this.favorisService.updateListeFavoris(id, favoris);
	}

}
