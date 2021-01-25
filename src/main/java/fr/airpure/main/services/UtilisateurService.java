package fr.airpure.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;
import fr.airpure.main.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	private UtilisateurRepository utilisateurRepo;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}
	
	/*
	 * Methode de recuperation de la liste  d'utilisateur
	 */
	
	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurRepo.findAll();
		
	}
	
	/*
	 * Methode de creation  d' un utilisateur
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
			throw new UtilisateurNotFoundException("Favoris inexistant veuillé le créer...");
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
		 * Methode de mise à jour d'un utilisateur
		 */
		
	public Utilisateur updateUtilisateur(Integer id, Utilisateur utilisateur) {
			utilisateur.setId(id);
			return this.utilisateurRepo.save(utilisateur);
			
		}
}
