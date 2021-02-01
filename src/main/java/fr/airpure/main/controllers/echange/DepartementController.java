package fr.airpure.main.controllers.echange;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.exceptions.DtoException;
import fr.airpure.main.dto.request.DtoDepartement;
import fr.airpure.main.entities.Departement;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.services.DepartementService;

@RestController
@CrossOrigin
@RequestMapping("departement")
public class DepartementController {
	private DepartementService departementService;
	public DepartementController(DepartementService departementService) {
		this.departementService = departementService;
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getDepartements() {
		try {
			List<Departement> departements = this.departementService.findAll();
			List<DtoDepartement> departementsDto = departements.stream().map(d -> new DtoDepartement(d)).collect(Collectors.toList());
			return ResponseEntity.ok(departementsDto);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(new DtoException(e.getMessage()));
		}
	
		
	}
}
