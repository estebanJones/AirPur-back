package fr.airpure.main.entities.echange;
/**
 * Notification class
 */

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.airpure.main.entities.Departement;

@Entity
public class Notification extends AbstractMessage{
	@ManyToOne
	@JoinColumn(name = "departement_id")
	private Departement departement;
	
	// CONSTRUCTEURS

	public Notification() {
		super();
	}
	
	// GETTERS & SETTERS
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	
	
}
