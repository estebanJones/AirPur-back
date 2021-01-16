package fr.airpure.main.managers;

import org.springframework.stereotype.Component;

import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.dto.response.RegisterDtoResponse;
import fr.airpure.main.entities.RoleUtilisateur;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.services.CheckerInscriptionService;
import fr.airpure.main.services.InscriptionService;
import fr.airpure.main.services.RoleUtilisateurService;
import fr.airpure.main.services.UtilisateurService;

@Component
public class InscriptionManager {
	private UtilisateurService utilisateurService;
	private RoleUtilisateurService roleUtilisateurService;
	private InscriptionService inscriptionService;
	private CheckerInscriptionService checkerInscriptionService;
	
	public InscriptionManager(UtilisateurService utilisateurService, RoleUtilisateurService roleUtilisateurService, InscriptionService inscriptionService,
			CheckerInscriptionService checkerInscriptionService) {
		this.utilisateurService = utilisateurService;
		this.roleUtilisateurService = roleUtilisateurService;
		this.inscriptionService = inscriptionService;
		this.checkerInscriptionService = checkerInscriptionService;
	}
	
	public RegisterDtoResponse inscription(RegisterDtoRequest dtoRequest) {
		this.inscriptionService.encodePassword(dtoRequest);
		Utilisateur utilisateur = this.utilisateurService.creerUtilisateur(dtoRequest);
		Utilisateur utilisateurDataBase = this.utilisateurService.persist(utilisateur);
		RoleUtilisateur roleParDefaut = this.inscriptionService.assignationRoleUtilisateur(utilisateurDataBase);
		this.roleUtilisateurService.persist(roleParDefaut);
		return new RegisterDtoResponse("Inscription réussie !");
	}
	
	public boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return this.checkerInscriptionService.controleInscriptionProprietes(dtoRequest);
	}
}
