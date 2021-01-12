package fr.airpure.main.services;

import org.springframework.stereotype.Service;

import fr.airpure.main.dto.RegisterDtoRequest;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	private UtilisateurRepository utilisateurRepo;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}
	
	public Utilisateur creerUtilisateur(RegisterDtoRequest dtoRequest) {
		return new Utilisateur(dtoRequest);
		
	}

	public Utilisateur persist(Utilisateur utilisateur) {
		return this.utilisateurRepo.save(utilisateur);
		
	}

}
