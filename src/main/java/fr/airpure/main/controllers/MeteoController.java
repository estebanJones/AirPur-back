package fr.airpure.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.response.MeteoDtoResponse;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.exceptions.CommuneIntrouvableException;
import fr.airpure.main.exceptions.MeteoIntrouvableException;
import fr.airpure.main.services.CommuneService;
import fr.airpure.main.services.MeteoService;

@RestController
@RequestMapping("/meteo")
public class MeteoController {
	
	@Autowired
	MeteoService meteoServ;
	
	public MeteoController () {}
		
		
		@GetMapping("{idCommune}")
		public  ResponseEntity<?> getLastMeteoByCommuneId (@PathVariable int idCommune) throws MeteoIntrouvableException {
			
			MeteoIndicateur fromRepo = this.meteoServ.getLastMeteoCommuneById(idCommune);
			
			if ( fromRepo == null ) {
				return ResponseEntity.ok("Aucun Relevé Météo n'a été trouvé pour la commune ID: " + idCommune);
			} else {
				MeteoDtoResponse dto = new MeteoDtoResponse(fromRepo);
				return ResponseEntity.ok(dto);
			}
			
		}
}
	
