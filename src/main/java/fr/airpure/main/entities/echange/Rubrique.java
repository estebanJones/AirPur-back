package fr.airpure.main.entities.echange;
/**
 * Rubrique message
 */
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Rubrique extends AbstractMessage{
	private String title;
	private String description;
	
	
	// CONSTRUCTEURS
	
	public Rubrique() {
		super();
	}

	// GETTERS & SETTERS
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
