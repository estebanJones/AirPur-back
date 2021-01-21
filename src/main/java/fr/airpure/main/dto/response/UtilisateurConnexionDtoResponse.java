package fr.airpure.main.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.airpure.main.entities.Utilisateur;

/**
 * Structure modèlisant un collègue servant à communiquer avec l'extérieur (WEB
 * API).
 */
public class UtilisateurConnexionDtoResponse {
	private Integer id;
	private String email;
	private String nom;
	private String prenom;
	
	private List<String> roles = new ArrayList<>();
	
	public UtilisateurConnexionDtoResponse(Utilisateur u) {
		super();
		this.id = u.getId();
		this.email = u.getEmail();
		this.nom = u.getNom();
		this.prenom = u.getPrenom();
		this.roles = u.getRoles().stream().map(roleUtilisateur -> String.valueOf(roleUtilisateur.getRole().getValue())).collect(Collectors.toList());
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
