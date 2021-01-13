package fr.airpure.main.entities.echange;
/**
 * Notification class
 */

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import fr.airpure.main.entities.Departement;
import fr.airpure.main.entities.Utilisateur;

@Entity
public class Notification extends LongIdEntity{
	private String message;
	private LocalDate dateCreation;
//	@ManyToMany
//	@JoinTable(name="notification_utilisateur",
//		joinColumns = @JoinColumn(name="notification_id", referencedColumnName = "id"),
//		inverseJoinColumns = @JoinColumn(name="utilisateur_id", referencedColumnName = "id")
//	)
	private List<Utilisateur> utilisateurs;
	
	public Notification() {
		this.dateCreation = LocalDate.now();
	}
	
	public Notification(String message, List<Utilisateur> utilisateurs,
			Departement departement) {
		super();
		this.message = message;
		this.dateCreation = LocalDate.now();
		this.utilisateurs = utilisateurs;
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

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	
	// CONSTRUCTEURS

	
	// GETTERS & SETTERS
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	
}
