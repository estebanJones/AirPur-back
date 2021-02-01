package fr.airpure.main.dto.echange;

import java.time.LocalDateTime;


public class MessageDto {
	private Integer id;
	private String content;
	private LocalDateTime postedOn;
	private Integer utilisateurId;
	private Integer rubriqueId;
	

	public MessageDto() {
		super();
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


	public Integer getRubriqueId() {
		return rubriqueId;
	}


	public void setRubriqueId(Integer rubriqueId) {
		this.rubriqueId = rubriqueId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
