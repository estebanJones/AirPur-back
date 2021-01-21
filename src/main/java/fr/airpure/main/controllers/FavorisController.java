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


import fr.airpure.main.dto.request.FavorisDtoRequest;
import fr.airpure.main.dto.response.FavorisDtoResponse;
import fr.airpure.main.entities.Commune;

import fr.airpure.main.dto.FavorisDto;
import fr.airpure.main.dto.ResponseFavorisDto;


@RequestMapping("accueil")
@RestController
@CrossOrigin
public class FavorisController {
	private FavorisService favorisService;

	public FavorisController(FavorisService favorisService) {
		super();
		this.favorisService = favorisService;
	}
	
	@PostMapping("/ajoutfavoris")
	public ResponseEntity<?> favoris (@RequestBody FavorisDtoRequest favorisDto, BindingResult requestValid) {

		if (!requestValid.hasErrors()) {

			this.favorisService.saveFavoris(commune1,meteo1, polluant1, dateDebut,dateDebut,dateFin);
		
			this.favorisService.saveFavoris(favorisDto.getCommune(),favorisDto.getAir(),favorisDto.getMeteo(), favorisDto.getChoixDateDebut(), favorisDto.getChoixDateFin());
			return ResponseEntity.ok(new FavorisDtoResponse("Favoris bien ajouté"));
		}
		else {

			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}
	}

	@GetMapping("/mesFavoris")
	public List<Favoris> getListeFavoris() {
		return favorisService.getMesFavoris();
	}

	@GetMapping("mesFavoris/{id}")
	public Favoris getUnFavoris(@PathVariable("id") Integer id) throws FavorisNotFoundException {
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
