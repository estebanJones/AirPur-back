package fr.airpure.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
	
	
	// PROPERTIES **************************************************************************************
	
	/** The repo commune. */
	@Autowired
	private CommuneRepository repoCommune;
	
	// CONSTRUCTORS **************************************************************************************
	
	/**
	 * Instantiates a new commune service.
	 */
	public CommuneService() {
		super();
	}
	
	/**
	 * Pour tester si la lecture fonctionne.
	 */
	public void test() {
		Commune commune3 = this.repoCommune.findById(3).get();
		System.out.println(commune3.toString());
	}
	
	public Commune findByCodeInsee(String codeInsee) throws NotFoundException {
		Optional<Commune> commune = this.repoCommune.findByCodeInseeCommune(codeInsee);
		if(commune.isPresent()) {
			return commune.get();
		} else {
			throw new NotFoundException();
		}
	}
	
	public Commune save(Commune commune) {
		return this.repoCommune.save(commune);
	}
	

}
