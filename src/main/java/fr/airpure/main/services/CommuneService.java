package fr.airpure.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.repositories.CommuneRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CommuneService.
 */
@Service
public class CommuneService {
	private CommuneRepository communeRepository;

	public CommuneService(CommuneRepository communeRepository) {
		this.communeRepository = communeRepository;
	}
	
	public Commune findByCodeInsee(String codeInsee) throws NotFoundException {
		Optional<Commune> commune = this.communeRepository.findByCodeInseeCommune(codeInsee);
		if(commune.isPresent()) {
			return commune.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	public Commune save(Commune commune) {
		return this.communeRepository.save(commune);
	}
	
	public List<Commune> getTop50Population() {
		return this.communeRepository.getTop50Population();
	}
	

}
