package fr.airpure.main.entities.echange;

/**
 * Message class
 */
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Message extends AbstractMessage {
	@ManyToOne
	private Rubrique rubrique;

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}
	
	
}
