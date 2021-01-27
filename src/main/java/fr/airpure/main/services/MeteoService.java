package fr.airpure.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Commune;
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

	public MeteoIndicateur getMeteoByID(int id) {
		return this.meteoRepository.findById(id).get();
	}
	
	public List <MeteoIndicateur> getMeteoByCommune(Commune commune) {
		return this.meteoRepository.findByCommuneId(commune.getId());
	}
	
	public void deleteMeteo(MeteoIndicateur meteoParam) {
		this.meteoRepository.delete(meteoParam);
	}
	
	/**
	 * Permet de vérifier l'existence d'un releveMeteo en BDD pour éviter les doublons
	 * @param meteoParam
	 * @return TRUE si le relevé Meteo en Param est trouvé en BDD, FALSE sinon.
	 */
	public boolean checkExistenceReleveMeteo( MeteoIndicateur meteoParam) {	
		List<MeteoIndicateur> listeMeteoBDD  = this.meteoRepository.findByDateAndCommuneId(meteoParam.getDate(), meteoParam.getCommune().getId());
			if ( listeMeteoBDD.size() > 0 ) {
				if (  listeMeteoBDD.get(0).getVitesseMoyVent() == meteoParam.getVitesseMoyVent() ) {
					return true;
				}
			} 
		return false;
		}
	

}
