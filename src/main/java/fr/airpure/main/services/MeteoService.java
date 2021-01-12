package fr.airpure.main.services;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.repositories.MeteoRepository;

@Service
public class MeteoService {
	private MeteoRepository meteoRepository;
	
	public MeteoService(MeteoRepository meteoRepository) {
		this.meteoRepository = meteoRepository;
	}
	
	public MeteoIndicateur save(MeteoIndicateur meteoIndicateur) {
		return this.meteoRepository.save(meteoIndicateur);
	}
}
