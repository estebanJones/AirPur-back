package fr.airpure.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;
import fr.airpure.main.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * Methode de recuperation de la liste d'utilisateur
	 */

	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurRepo.findAll();

	}

	/*
	 * Methode de creation d' un utilisateur
	 */
	public Utilisateur creerUtilisateur(RegisterDtoRequest dtoRequest) {
		return new Utilisateur(dtoRequest);

	}

	public Utilisateur persist(Utilisateur utilisateur) {
		return this.utilisateurRepo.save(utilisateur);

	}

	/*
	 * Methode de recuperation d'un utilisateur
	 */

	public Utilisateur getUtilisateur(Integer id) throws UtilisateurNotFoundException {
		Optional<Utilisateur> optionalUtilisateur = utilisateurRepo.findById(id);

		if (!optionalUtilisateur.isPresent()) {
			throw new UtilisateurNotFoundException("Utilisateur inexistant veuillé le créer...");
		}
		return optionalUtilisateur.get();
	}

	/*
	 * Methode de supression d'un utilisateur
	 */
	public void deleteUtilisateur(Integer id) {
		this.utilisateurRepo.deleteById(id);
	}

	/*
	 * Encode Mot de passe utilisateur
	 * 
	 */

	public void encodePassword(Utilisateur utilisateur) {
		utilisateur.setMotDePasse(this.passwordEncoder.encode(utilisateur.getMotDePasse()));
	}

	/*
	 * Methode de mise à jour d'un utilisateur Encode le mot de passe
	 * passwordEncoder Puis met à jour le mot de passe en BD UpdateUtilisateur et
	 * Update je teste les deux
	 */

	// Methode Update 1
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
		this.encodePassword(utilisateur);
		return this.utilisateurRepo.save(utilisateur);
	}

	// Methode Update 2
	public Utilisateur update(Integer id, Utilisateur utilisateur) {
		if (!utilisateurRepo.existsById(id)) {
			throw new RuntimeException("Utilisateur n'existe pas en base");
		}
		utilisateur.setId(id);
		return this.utilisateurRepo.save(utilisateur);
	}

}
