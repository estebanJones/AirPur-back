package fr.airpure.main.entities.echange;
/**
 * Notification class
 */

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.airpure.main.entities.Departement;
import fr.airpure.main.entities.Utilisateur;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
	// CONSTRUCTEURS

	
	// GETTERS & SETTERS
	
	
	
}
