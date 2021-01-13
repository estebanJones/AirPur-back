package fr.airpure.main.controllers.echange;
/*
 * Controller pour la gestion des suspension
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

import fr.airpure.main.dto.SuspensionDto;
import fr.airpure.main.dto.response.ResponseSuspensionDto;
import fr.airpure.main.entities.echange.Suspension;
import fr.airpure.main.exceptions.echange.SuspensionNotFoundException;
import fr.airpure.main.services.echange.SuspensionService;

@RequestMapping("accueil/forum")
@RestController
@CrossOrigin
public class SuspensionController {
	private SuspensionService suspensionService;

	public SuspensionController(SuspensionService suspensionService) {
		super();
		this.suspensionService = suspensionService;
	}

	@PostMapping("/suspendre")
	public ResponseEntity<?> suspension(@RequestBody SuspensionDto suspensionDto, BindingResult requestValid) {
		if (!requestValid.hasErrors()) {
			this.suspensionService.createAndSaveSuspension(suspensionDto.getUserAdminId(),suspensionDto.getUserSuspenduId(),suspensionDto.getDefinitif(),suspensionDto.getTemporaire());
			return ResponseEntity.ok(new ResponseSuspensionDto("Suspension bien ajouté"));
		} else {
			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}
	}

	@GetMapping("/mesSuspension")
	public List<Suspension> getMesSuspensions() {
		return suspensionService.getSuspensions();
	}

	@GetMapping("/{id}")
	public Suspension getSuspension(@PathVariable("id") Integer id) throws SuspensionNotFoundException {
		return this.suspensionService.getSuspension(id);
	}

	@DeleteMapping("/{id}")
	public void deleteMaSuspension(@PathVariable("id") Integer id) {
		this.suspensionService.deleteSuspension(id);
	}

	@PutMapping("/{id}")
	public Suspension updateSuspension(@PathVariable("id") Integer id, @RequestBody Suspension suspension) {
		return this.suspensionService.updateListeSuspension(id, suspension);
	}
}
