package fr.airpure.main.managers;

import org.springframework.stereotype.Component;

import fr.airpure.main.dto.RegisterDtoRequest;
import fr.airpure.main.dto.RegisterDtoResponse;
import fr.airpure.main.entities.RoleUtilisateur;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.enums.ERole;
import fr.airpure.main.services.RoleUtilisateurService;
import fr.airpure.main.services.UtilisateurService;

@Component
public class InscriptionManager {
	private UtilisateurService utilisateurService;
	private RoleUtilisateurService roleUtilisateurService;
	
	public InscriptionManager(UtilisateurService utilisateurService, RoleUtilisateurService roleUtilisateurService) {
		this.utilisateurService = utilisateurService;
		this.roleUtilisateurService = roleUtilisateurService;
	}
	
	public RegisterDtoResponse inscription(RegisterDtoRequest dtoRequest) {
		Utilisateur utilisateur = this.utilisateurService.creerUtilisateur(dtoRequest);
		Utilisateur utilisateurDataBase = this.utilisateurService.persist(utilisateur);
		RoleUtilisateur roleParDefaut = this.assignationRoleUtilisateur(utilisateurDataBase);
		this.roleUtilisateurService.persist(roleParDefaut);
		return new RegisterDtoResponse("Inscription réussie !");
	}
	
	private RoleUtilisateur assignationRoleUtilisateur(Utilisateur utilisateur) {
		RoleUtilisateur roleParDefaut = this.creationRoleUtilisateur(utilisateur);
		roleParDefaut.setUtilisateur(utilisateur);
		return roleParDefaut;
	}
	
	private RoleUtilisateur creationRoleUtilisateur(Utilisateur utilisateur) {
		return new RoleUtilisateur(utilisateur, ERole.ROLE_UTILISATEUR);
	}
}
