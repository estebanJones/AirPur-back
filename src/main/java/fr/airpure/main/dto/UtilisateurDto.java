package fr.airpure.main.dto;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurDto {
	private Integer id;
	private String email;
	private String nom;
	private String prenom;

	public UtilisateurDto() {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
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

}
