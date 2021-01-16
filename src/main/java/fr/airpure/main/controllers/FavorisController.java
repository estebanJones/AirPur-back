package fr.airpure.main.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

import fr.airpure.main.dto.request.FavorisDtoRequest;
import fr.airpure.main.dto.response.FavorisDtoResponse;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.entities.Polluant;
import fr.airpure.main.exceptions.FavorisNotFoundException;
import fr.airpure.main.services.FavorisService;

@RequestMapping("acceuil")
@RestController
//@CrossOrigin
public class FavorisController {
	private FavorisService favorisService;
	public FavorisController(FavorisService favorisService) {
		super();
		this.favorisService = favorisService;
	}
	
	@PostMapping("/ajoutfavoris")
	public ResponseEntity<?> favoris (@RequestBody FavorisDtoRequest favorisDto, BindingResult requestValid) {
		if (!requestValid.hasErrors()) {
			/*
			Commune commune1 = new Commune();
			MeteoIndicateur meteo1 = new MeteoIndicateur();
			Polluant polluant1 = new Polluant();
			LocalDateTime dateDebut = LocalDateTime.parse("2021-01-11 14:00:00", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
			LocalDateTime dateFin = LocalDateTime.parse("2021-01-11 18:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			this.favorisService.saveFavoris(commune1,meteo1, polluant1, dateDebut,dateDebut,dateFin);
			*/
			this.favorisService.saveFavoris(favorisDto.getCommune(),favorisDto.getAir(),favorisDto.getMeteo(), favorisDto.getChoixDateDebut(), favorisDto.getChoixDateFin());
			return ResponseEntity.ok(new FavorisDtoResponse("Favoris bien ajouté"));
		}
		else {
			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}		
	}
	
	@GetMapping("/mesFavoris")
	public List<Favoris> getMesFavoris(){
		return favorisService.getFavoris();
	}
		
	@GetMapping("/{id}")
	public Favoris getFavoris(@PathVariable("id") Integer id) throws FavorisNotFoundException {
		return this.favorisService.getFavoris(id);
		}
	
	@DeleteMapping("/{id}")
	public void deleteMonFavoris(@PathVariable("id") Integer id) {
		this.favorisService.deleteFavoris(id);;
	}
			
	@PutMapping("/{id}")
	public Favoris updateMaListeFavoris(@PathVariable("id") Integer id,@RequestBody Favoris favoris) {
		return this.favorisService.updateListeFavoris(id, favoris);
	}
	
}
