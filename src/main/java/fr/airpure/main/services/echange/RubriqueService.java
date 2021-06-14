package fr.airpure.main.services.echange;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.exceptions.echange.EchangeNotFoundException;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.repositories.echange.RubriqueRepo;

@Service
public class RubriqueService {
	@Autowired
	private RubriqueRepo rubriqueRepo;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	/*
	 * Methode de création de Rubrique
	 */
	public Rubrique createRubrique(Integer utilisateurId, String title, String description, String content,
			LocalDateTime postedOn) {
		Utilisateur utilisateur = this.utilisateurRepository.getOne(utilisateurId);
		Rubrique nouveauRubrique = new Rubrique();
		nouveauRubrique.setTitle(title);
		nouveauRubrique.setDescription(description);
		nouveauRubrique.setContent(content);
		nouveauRubrique.setPostedOn(postedOn);
		nouveauRubrique.setUtilisateur(utilisateur);
		return nouveauRubrique;

	}

	/*
	 * Methode de sauvegarde de Rubrique
	 */

	public Rubrique saveRubrique(Rubrique nouveauRubrique) {
		return this.rubriqueRepo.save(nouveauRubrique);
	}

	public Rubrique createAndSaveRubrique(Integer utilisateurId, String title, String description, String content,
			LocalDateTime postedOn) {
		Rubrique rubrique = this.createRubrique(utilisateurId, title, description, content, postedOn);
		return this.saveRubrique(rubrique);
	}

	/*
	 * Methode de recupération de la liste des rubriques
	 */
	public List<Rubrique> getTousLesRubriques() {
		return this.rubriqueRepo.findAll();
	}
	/*
	 * Methode de recupération de la liste des rubrique de l'utilisateur
	 */

	public List<Rubrique> getMesRubriques(Integer utilisateurId) {
		return this.rubriqueRepo.findByUtilisateurId(utilisateurId);
	}

	/*
	 * Methode de recuperation de rubriques
	 */
	public Rubrique getRubrique(Integer id) throws EchangeNotFoundException {
		Optional<Rubrique> optionalRubrique = rubriqueRepo.findById(id);

		if (!optionalRubrique.isPresent()) {
			throw new EchangeNotFoundException("Rubrique inexistant veuillé le créer...");
		}
		return optionalRubrique.get();

	}

	/*
	 * Methode pour Supprimer un rubrique
	 */
	public void deleteRurbique(Integer id) {
		rubriqueRepo.deleteById(id);
	}

	/*
	 * Methode Mise à jour de rubrique
	 */

	// Methode 1
	// Methode Update 1
	public Rubrique updateRubrique(Rubrique rubrique) {
		return this.rubriqueRepo.save(rubrique);
	}

	// Methode 2
	/*
	 * public Rubrique update(Integer id, Rubrique rubrique) {
	 * if(!rubriqueRepo.existsById(id)) { throw new
	 * RuntimeException("Rubrique n'existe pas en base"); } rubrique.setId(id);
	 * return rubriqueRepo.save(rubrique); }
	 */

}
