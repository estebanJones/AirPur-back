package fr.airpure.main.dto.echange;

import java.time.LocalDateTime;

public class RubriqueDto {
	private String title;
	private String description;
	private String content;
	private Integer utilisateurId;
	private LocalDateTime postedOn;
	
	
	public RubriqueDto(String title, String description, String content, LocalDateTime postedOn) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
		this.postedOn = postedOn;
	}

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

	public Integer getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	
}
