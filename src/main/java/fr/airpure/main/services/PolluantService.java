package fr.airpure.main.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.airpure.main.autoGenerated.Feature;
import fr.airpure.main.entities.Polluant;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.repositories.PolluantRepository;

@Service
public class PolluantService {
	private PolluantRepository polluantRepository;
	
	public PolluantService(PolluantRepository polluantRepository) {
		this.polluantRepository = polluantRepository;
	}
	
	public Polluant creer(Feature m, LocalDateTime dateDebutAnalyse, LocalDateTime dateFinAnalyse) {
		return new Polluant(m.getProperties().getNomPoll(),  
				 m.getProperties().getValeur(),
				 m.getProperties().getMetrique(), 
				 dateDebutAnalyse, dateFinAnalyse);
	}
	
	public Polluant save(Polluant polluant) {
		return this.polluantRepository.save(polluant);
	}
	
	public List<Polluant> getDernierPolluantByStation(Integer idStation) throws NotFoundException {
		return this.polluantRepository.getDernierPolluantByStation(idStation);
	}
}
