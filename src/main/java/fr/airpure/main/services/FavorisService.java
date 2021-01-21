package fr.airpure.main.services;

import java.time.LocalDateTime;

/**
 * Service de CRUD d'un favoris
 */

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.repositories.CommuneRepository;
import fr.airpure.main.repositories.FavorisRepository;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.exceptions.FavorisNotFoundException;

//Methode de service : faire le getCommune , puis charger les AirIndicateur et Meteo Si True, Puis Sauvegarder en base

@Service
public class FavorisService {
	private FavorisRepository favorisRepository;
	private CommuneRepository communeRepository;
	private UtilisateurRepository utilisateurRepository;

	public FavorisService(FavorisRepository favorisRepository, CommuneRepository communeRepository, UtilisateurRepository utilisateurRepository) {
		super();
		this.favorisRepository = favorisRepository;
		this.communeRepository = communeRepository;
		this.utilisateurRepository = utilisateurRepository;
	}
	
	/*
	 * Methode de création de Favoris
	 */
	public Favoris createFavoris(Integer communeId, Integer utilisateurId, Boolean meteo, Boolean air, LocalDateTime choixDateDebut, LocalDateTime choixDateFin) {
		Commune commune = this.communeRepository.getOne(communeId);
		Utilisateur utilisateur = this.utilisateurRepository.getOne(utilisateurId);
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
<<<<<<< HEAD
	public List<Favoris> getMesFavoris() {
=======
	public List<Favoris> getAllFavoris() {
>>>>>>> d64ee7d812a5c89f0e07379e2222a926f8f0bd47
		return favorisRepository.findAll();
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