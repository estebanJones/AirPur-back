package fr.airpure.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.repositories.UtilisateurRepository;

@Service
public class SecurityMethodsService {
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	/*
	 * Methode pour recupérer l'utilisateur connecté
	 * Si l'ID de l'utilisateur est trouvé en BD
	 * et l'Email de l'utilisateur en base est égale à l'utilisateur connecte
	 */
	public boolean isConnectedUser(Integer utilisateurID,UserDetails utilisateurConnecter ) {
		Utilisateur utilisateur = utilisateurRepository.findById(utilisateurID).orElse(null);
		return utilisateur != null && utilisateur.getEmail().equals(utilisateurConnecter.getUsername());
		
	}
}
