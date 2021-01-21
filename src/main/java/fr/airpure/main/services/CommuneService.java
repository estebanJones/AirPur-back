package fr.airpure.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.entities.Station;
import fr.airpure.main.exceptions.CommuneIntrouvableException;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.repositories.CommuneRepository;
import fr.airpure.main.repositories.FavorisRepository;
import fr.airpure.main.repositories.MeteoRepository;
import fr.airpure.main.repositories.StationRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CommuneService.
 */
@Service
public class CommuneService {
	
	@Autowired
	private CommuneRepository communeRepository;
	
	@Autowired
	private StationRepository stationRepository;
	
	@Autowired
	private MeteoRepository meteoRepository;
	
	@Autowired
	private FavorisRepository favorisRepository;

	public CommuneService() {
		
	}
	
	/**
	 * Retrouve une commune en BDD grâce à son code INSEE fourni en param
	 * @param codeInsee
	 * @return Un Objet Commune avec toutes ses informations
	 * @throws CommuneIntrouvableException
	 */
	public Commune findByCodeInsee(String codeInsee) throws CommuneIntrouvableException {
		Optional<Commune> commune = this.communeRepository.findByCodeInseeCommune(codeInsee);
		if(commune.isPresent()) {
			//Commune communeComplete = this.complementInfosCommune(commune.get());
			return commune.get();
		} else {
			throw new CommuneIntrouvableException("La commune dont le code INSEE est" + codeInsee + " est introuvable en BDD");
		}
	}
	
	
	public Commune save(Commune commune) {
		return this.communeRepository.save(commune);
	}
	
	
	public List<Commune> getTop50Population() {
		return this.communeRepository.getTop50Population();
	}
	
	public Commune getById(int idCommune) throws CommuneIntrouvableException{
		Optional<Commune> commune = this.communeRepository.findById(idCommune);
		if(commune.isPresent()) {
			return commune.get();
		} else {
			throw new CommuneIntrouvableException("La commune dont l'ID est" + idCommune + " est introuvable en BDD");
		}
	}

	
	/**
	 * Passe par les repo concernés pour fournir à l'objet commune placé en param les informations suivantes :
	 * - Liste des Stations liés à la commune
	 * - Liste des indicateurs Météos lié à la commune
	 * - Liste des favoris liés à la commune
	 * @param communeParam
	 * @return un Objet commune avec toutes les informations de la BDD lié à elle
	 */
//	public Commune complementInfosCommune(Commune communeParam) {
//		Commune fullCommune = communeParam;
//		
//		//Ajout des stations
//		List<Station> listeStationCommune = this.stationRepository.findByCommuneId(communeParam.getId());
//		for ( Station s : listeStationCommune ) {
//			fullCommune.getStations().add(s);
//		}
//		
//		//Ajout des indicateurs météos
//		List<MeteoIndicateur> listeRelevesMeteoCommune = this.meteoRepository.findByCommuneId(communeParam.getId());
//		for ( MeteoIndicateur m : listeRelevesMeteoCommune) {
//			fullCommune.getMeteoIndicateurs().add(m);
//		}
//		
//		
//		//Ajout des favoris
//		List<Favoris> listeFavorisCommune = this.favorisRepository.findByCommuneId(communeParam.getId());
//		for ( Favoris f : listeFavorisCommune ) {
//			fullCommune.getFavoris().add(f);
//		}
//		
//		return fullCommune;
//	}
}

