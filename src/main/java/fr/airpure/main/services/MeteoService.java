package fr.airpure.main.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.exceptions.MeteoIntrouvableException;
import fr.airpure.main.managers.ExtractAtmoApiManager;
import fr.airpure.main.repositories.MeteoRepository;

@Service
public class MeteoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExtractAtmoApiManager.class);
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

	public List<MeteoIndicateur> getMeteoByCommune(Commune commune) {
		return this.meteoRepository.findByCommuneId(commune.getId());
	}

	public MeteoIndicateur getLastMeteoCommuneById(int idCommune) throws MeteoIntrouvableException {

		Optional<MeteoIndicateur> lastMeteo = this.meteoRepository.findLastMeteoByCommune(idCommune);
		MeteoIndicateur retour = null;
		if (lastMeteo.isEmpty()) {
			//throw new MeteoIntrouvableException("Aucun relevé Météo trouvé pour la commune à l'ID : " + idCommune);
			LOG.info("Aucun relevé Météo trouvé pour la commune à l'ID : " + idCommune);
		} else {
			retour = lastMeteo.get();
		}
		return retour;
	}

	public void deleteMeteo(MeteoIndicateur meteoParam) {
		this.meteoRepository.delete(meteoParam);
	}

	/**
	 * Permet de vérifier l'existence d'un releveMeteo en BDD pour éviter les
	 * doublons
	 * 
	 * @param meteoParam
	 * @return TRUE si le relevé Meteo en Param est trouvé en BDD, FALSE sinon.
	 */
	public boolean checkExistenceReleveMeteo(MeteoIndicateur meteoParam) {
		List<MeteoIndicateur> listeMeteoBDD = this.meteoRepository.findByDateAndCommuneId(meteoParam.getDate(),
				meteoParam.getCommune().getId());
		if (listeMeteoBDD.size() > 0) {
			if (listeMeteoBDD.get(0).getVitesseMoyVent() == meteoParam.getVitesseMoyVent()) {
				return true;
			}
		}
		return false;
	}

}
