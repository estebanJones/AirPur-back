package fr.airpure.main.dto.echange;

import java.time.LocalDateTime;

public class RubriqueDtoFront {
	private String title;
	private String description;
	private String content;
	private LocalDateTime postedOn;
	
	public RubriqueDtoFront() {
		super();
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

	

	
	

}
