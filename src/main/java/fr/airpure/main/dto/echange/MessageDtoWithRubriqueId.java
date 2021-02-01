package fr.airpure.main.dto.echange;

import java.time.LocalDateTime;

public class MessageDtoWithRubriqueId {
	
	private Integer id;
	private String content;
	private LocalDateTime postedOn;
	private Integer rubriqueId;
	
	public MessageDtoWithRubriqueId() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getRubriqueId() {
		return rubriqueId;
	}

	public void setRubriqueId(Integer rubriqueId) {
		this.rubriqueId = rubriqueId;
	}
	
	
}

