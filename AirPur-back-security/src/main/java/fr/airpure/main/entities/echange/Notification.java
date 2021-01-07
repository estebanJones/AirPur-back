package fr.airpure.main.entities.echange;
/**
 * Notification class
 */

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Notification extends AbstractMessage{
	//Attend la mise en place de l'entite departement
	@ManyToOne
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
