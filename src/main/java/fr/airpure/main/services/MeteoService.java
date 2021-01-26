package fr.airpure.main.services;

import java.util.Optional;

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

	
	/**
	 * Permet de vérifier l'existence d'un releveMeteo en BDD pour éviter les doublons
	 * @param meteoParam
	 * @return TRUE si le relevé Meteo en Param est trouvé en BDD, FALSE sinon.
	 */
	public boolean checkExistenceReleveMeteo( MeteoIndicateur meteoParam) {	
		Optional<MeteoIndicateur> meteoBDD  = this.meteoRepository.findByDateAndCommuneId(meteoParam.getDate(), meteoParam.getCommune().getId());
			if ( !meteoBDD.isEmpty() ) {
				if (  meteoBDD.get().getVitesseMoyVent() == meteoParam.getVitesseMoyVent() ) {
					return true;
				}
			} 
		return false;
		}
}
