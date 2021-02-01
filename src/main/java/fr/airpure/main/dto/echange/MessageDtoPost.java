package fr.airpure.main.dto.echange;

import java.time.LocalDateTime;

public class MessageDtoPost {
	private String content;
	private LocalDateTime postedOn;
	private Integer utilisateurId;
	private Integer rubriqueId;
	
	
	public MessageDtoPost() {
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
	
	
	
}
