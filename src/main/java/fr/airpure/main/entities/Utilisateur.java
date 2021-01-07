package fr.airpure.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String pseudo;
	private String email;

	private String motDePasse;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
	private List<RoleUtilisateur> roles = new ArrayList<>();
	
	
	public Utilisateur(String nom, String prenom, String email, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}


	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public List<RoleUtilisateur> getRoles() {
		return roles;
	}


	public void setRoles(List<RoleUtilisateur> roles) {
		this.roles = roles;
	}
	
	
}
