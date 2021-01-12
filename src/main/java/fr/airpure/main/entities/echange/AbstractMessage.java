package fr.airpure.main.entities.echange;
/**
 * AbstractMessage class
 * 
 */
import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import fr.airpure.main.entities.Utilisateur;

@MappedSuperclass
public abstract class AbstractMessage extends LongIdEntity {
	protected String content;
	protected LocalDateTime postedOn;
	
	@ManyToOne
	protected Utilisateur utilisateur;
	
	// CONSTRUCTEURS
	public AbstractMessage() {
		super();
	}
	
	// GETTERS & SETTERS
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDateTime postedOn) {
		this.postedOn = postedOn;
	}
}
