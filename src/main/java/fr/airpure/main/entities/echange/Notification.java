package fr.airpure.main.entities.echange;
/**
 * Notification class
 */

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.airpure.main.entities.Departement;
import fr.airpure.main.entities.Utilisateur;

@Entity
public class Notification extends LongIdEntity{
	private String message;
	private LocalDate dateCreation;
	
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	
	public Notification() {
		this.dateCreation = LocalDate.now();
	}
	
	public Notification(String message, Utilisateur utilisateur,
			Departement departement) {
		super();
		this.message = message;
		this.dateCreation = LocalDate.now();
		this.utilisateur = utilisateur;
		this.departement = departement;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateurs(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
	// CONSTRUCTEURS

	
	// GETTERS & SETTERS
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	
}
