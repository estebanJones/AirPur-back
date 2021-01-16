package fr.airpure.main.managers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.RoleUtilisateur;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.enums.ERole;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.services.CommuneService;
import fr.airpure.main.services.InscriptionService;
import fr.airpure.main.services.PolluantService;
import fr.airpure.main.services.StationService;
import fr.airpure.main.services.UtilisateurService;
import fr.airpure.main.utils.DateUtils;


/** 
 * Permet d'initialiser et persister des entites au démarrage de l'application
 * @author Exost
 *
 */
@Service
public class InitialDataManager {
	
	@Autowired
	private DateUtils dateUtils;
	
	@Autowired
	private CommuneService communeService;
	
	@Autowired
	private StationService stationService;
	
	@Autowired
	private PolluantService polluantService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private InscriptionService inscriptionService;
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;


	
	public void insertBaseDataForTest() {
		
		//RoleUtilisateur rolesUtilisateur = new RoleUtilisateur(userAdmin, ROLE_UTILISATEUR);
		
		/*
		 * Utilisateur userAdmin = new Utilisateur(1, "nomAdmin", "prenomAdmin", "Admin", "mail@admin.com", "adminPwd", null );
		RoleUtilisateur roleAdmin = new RoleUtilisateur(userAdmin, ERole.ROLE_ADMINISTRATEUR);
		Set<RoleUtilisateur> setRolesAdmin = new HashSet<RoleUtilisateur>();
		setRolesAdmin.add(roleAdmin);
		userAdmin.setRoles( setRolesAdmin ) ;
		this.utilisateurRepo.save(userAdmin);
		
		Utilisateur userLambda1 = new Utilisateur(1, "nomLambda1", "prenomLambda1", "Lambda1", "mail@Lambda1.com", "Lambda1Pwd", null);
		this.inscriptionService.assignationRoleUtilisateur(userLambda1);
		
		Utilisateur userLambda2 = new Utilisateur(1, "nomLamba2", "prenomLamba2", "Lamba2", "mail@Lamba2.com", "Lambda2Pwd", null);
		this.inscriptionService.assignationRoleUtilisateur(userLambda2); */
		
	}
	
}
