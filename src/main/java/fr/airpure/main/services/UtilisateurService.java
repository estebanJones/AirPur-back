package fr.airpure.main.services;

import java.util.List;

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
	
	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurRepo.findAll();
		
	}
	public Utilisateur creerUtilisateur(RegisterDtoRequest dtoRequest) {
		return new Utilisateur(dtoRequest);
		
	}

	public Utilisateur persist(Utilisateur utilisateur) {
		return this.utilisateurRepo.save(utilisateur);
		
	}

}
