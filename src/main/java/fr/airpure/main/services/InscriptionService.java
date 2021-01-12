package fr.airpure.main.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.airpure.main.dto.RegisterDtoRequest;
import fr.airpure.main.entities.RoleUtilisateur;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.enums.ERole;

@Service
public class InscriptionService {
	private PasswordEncoder passwordEncoder;
	
	public InscriptionService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public RoleUtilisateur assignationRoleUtilisateur(Utilisateur utilisateur) {
		RoleUtilisateur roleParDefaut = this.creationRoleUtilisateur(utilisateur);
		roleParDefaut.setUtilisateur(utilisateur);
		return roleParDefaut;
	}
	
	public RoleUtilisateur creationRoleUtilisateur(Utilisateur utilisateur) {
		return new RoleUtilisateur(utilisateur, ERole.ROLE_UTILISATEUR);
	}
	
	public void encodePassword(RegisterDtoRequest dtoRequest) {
		dtoRequest.setPassword(this.passwordEncoder.encode(dtoRequest.getPassword()));
	}
}
