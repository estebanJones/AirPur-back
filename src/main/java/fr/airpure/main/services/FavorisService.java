package fr.airpure.main.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Service de CRUD d'un favoris
 */

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.airpure.main.dto.response.DtoFavoris;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.entities.Polluant;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.exceptions.FavorisNotFoundException;
import fr.airpure.main.repositories.CommuneRepository;
import fr.airpure.main.repositories.FavorisRepository;
import fr.airpure.main.repositories.MeteoRepository;
import fr.airpure.main.repositories.PolluantRepository;
import fr.airpure.main.repositories.UtilisateurRepository;

//Methode de service : faire le getCommune , puis charger les AirIndicateur et Meteo Si True, Puis Sauvegarder en base

@Service
public class FavorisService {
	private FavorisRepository favorisRepository;
	private CommuneRepository communeRepository;
	private MeteoRepository meteoRepository;
	private PolluantRepository polluantRepository;
	private UtilisateurRepository utilisateurRepository;

	public FavorisService(FavorisRepository favorisRepository, CommuneRepository communeRepository, UtilisateurRepository utilisateurRepository,
			MeteoRepository meteoRepository, PolluantRepository polluantRepository) {
		super();
		this.favorisRepository = favorisRepository;
		this.communeRepository = communeRepository;
		this.utilisateurRepository = utilisateurRepository;
		this.polluantRepository = polluantRepository;
		this.meteoRepository = meteoRepository;
	}
	
	/*
	 * Methode de création de Favoris
	 */
	public Favoris createFavoris(Integer communeId, Integer utilisateurId, Boolean meteo, Boolean air, LocalDateTime choixDateDebut, LocalDateTime choixDateFin) {
		Commune commune = this.communeRepository.findById(communeId).get();
		Utilisateur utilisateur = this.utilisateurRepository.findById(utilisateurId).get();
		Favoris nouveauFavoris = new Favoris();
		nouveauFavoris.setCommune(commune);
		nouveauFavoris.setAir(air);
		nouveauFavoris.setMeteo(meteo);
		nouveauFavoris.setChoixDateDebut(choixDateDebut);
		nouveauFavoris.setChoixDateFin(choixDateFin);
		nouveauFavoris.setUtilisateur(utilisateur);
		return nouveauFavoris;
		
	}
	
	/*
	 * Methode de sauvegarde de Favoris
	 */
	
	public Favoris saveFavoris(Favoris nouveauFavoris) {
		return this.favorisRepository.save(nouveauFavoris);
	}
	
	public Favoris createAndSaveFavoris(Integer communeId,Integer utilisateurId, Boolean meteo, Boolean air, LocalDateTime choixDateDebut, LocalDateTime choixDateFin){
		Favoris favoris = this.createFavoris(communeId, utilisateurId, meteo, air, choixDateDebut, choixDateFin);	
		return this.saveFavoris(favoris);
		
		
	}
	
	
	/*
	 * Methode de recupération de la liste des Favoris
	 */
	public List<Favoris> getTousLesFavoris() {
		return favorisRepository.findAll();
	}
	/*
	 * Methode de recupération de la liste des Favoris de l'utilisateur
	 */
/*	
	public List<Favoris> getMesFavoris() {
		return favorisRepository.findByUtilisateurId(utilisateurId);
	}	
	*/
	
	/*
	 * Methode de recupération de la liste des Favoris
	 */
	public List<DtoFavoris> getFavorisByUtilisateur(Integer utilisateurId) {
		// je prends les favoris de l'utilisateur
		List<Favoris> favoris = favorisRepository.findByUtilisateurId(utilisateurId);
		List<DtoFavoris> dtoFavoris = new ArrayList<>();
		// pour chaque favoris je prends les infos liées
		favoris.forEach(f -> {
			List<MeteoIndicateur> meteoIndicateurs = this.meteoRepository.findByDateBetweenAndCommuneId(f.getChoixDateDebut(), f.getChoixDateFin(), f.getCommune().getId());
			List<Polluant> polluants = this.polluantRepository.findByDateDebutGreaterThanEqualAndDateFinLessThanEqualAndStationCommuneId(f.getChoixDateDebut(), f.getChoixDateFin(), f.getCommune().getId());
			dtoFavoris.add(new DtoFavoris(meteoIndicateurs, polluants));
		});
		// JE DOIS PRENDRE LES METEO ET LES POLLUANTS DANS UN INTERVAL DE DATE
		return dtoFavoris;
	}
	
	/*
	 * Methode de recuperation de Favoris
	 */
	public Favoris getFavoris(Integer id) throws FavorisNotFoundException {
		Optional<Favoris> optionalFavoris = favorisRepository.findById(id);

		if (!optionalFavoris.isPresent()) {
			throw new FavorisNotFoundException("Favoris inexistant veuillé le créer...");
		}
		return optionalFavoris.get();

	}
	
	/*
	 * Methode pour Supprimer un favoris
	 */	
	public void deleteFavoris(Integer id) {
		favorisRepository.deleteById(id);
	}
	
	/*
	 * Methode Mise à jour de favoris
	 */

	public Favoris updateListeFavoris(Integer id, Favoris favoris) {
		favoris.setId(id);
		return favorisRepository.save(favoris);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}