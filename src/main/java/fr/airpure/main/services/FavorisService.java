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
import fr.airpure.main.repositories.FavorisRepository;
import fr.airpure.main.exceptions.FavorisNotFoundException;

//Methode de service : faire le getCommune , puis charger les AirIndicateur et Meteo Si True, Puis Sauvegarder en base

@Service
public class FavorisService {
	private FavorisRepository favorisRepository;

	public FavorisService(FavorisRepository favorisRepository) {
		super();
		this.favorisRepository = favorisRepository;
	}
	
	/*
	 * Methode de création de Favoris
	 */
	public Favoris createFavoris(Commune commune, Boolean meteo, Boolean air, LocalDateTime choixDateDebut, LocalDateTime choixDateFin) {
		Favoris nouveauFavoris = new Favoris();
		nouveauFavoris.setCommune(commune);
		nouveauFavoris.setAir(false);
		nouveauFavoris.setMeteo(false);
		nouveauFavoris.setChoixDateDebut(choixDateDebut);
		nouveauFavoris.setChoixDateFin(choixDateFin);
		return nouveauFavoris;
	}
	
	/*
	 * Methode de sauvegarde de Favoris
	 */
	public Favoris saveFavoris(Commune commune, Boolean meteo, Boolean air, LocalDateTime choixDateDebut, LocalDateTime choixDateFin) {
		Favoris nouveauFavoris = this.createFavoris(commune, meteo, air, choixDateDebut, choixDateFin);
		return this.favorisRepository.save(nouveauFavoris);
	}
	
	/*
	 * Methode de recupération de la liste des Favoris
	 */
	public List<Favoris> getFavoris() {
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