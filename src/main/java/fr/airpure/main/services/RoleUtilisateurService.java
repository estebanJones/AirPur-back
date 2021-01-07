package fr.airpure.main.services;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.RoleUtilisateur;
import fr.airpure.main.repositories.RoleUtilisateurRepository;

@Service
public class RoleUtilisateurService {
	private RoleUtilisateurRepository roleUtilisateurRepository;
	
	public RoleUtilisateurService(RoleUtilisateurRepository roleUtilisateurRepository) {
		this.roleUtilisateurRepository = roleUtilisateurRepository;
	}
	
	public RoleUtilisateur persist(RoleUtilisateur role) {
		return this.roleUtilisateurRepository.save(role);
	}
}
