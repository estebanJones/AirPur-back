package fr.airpure.main.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Departement;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.repositories.DepartementRepository;

/**
 * The Class DepartementService.
 */
@Service
public class DepartementService {
	private DepartementRepository departementRepository;
	
	public DepartementService(DepartementRepository departementRepository) {
		this.departementRepository = departementRepository;
	}
	
	public Departement findByNom(String nomDepartement) throws NotFoundException {
		Optional<Departement> departement = this.departementRepository.findByNomDepartement(nomDepartement);
		if(departement.isPresent()) {
			return departement.get();
		} else {
			throw new NotFoundException();
		}
	}
}
