package fr.airpure.main.dto.echange;

import java.time.LocalDateTime;

public class MessageDtoFront {
	private Integer id;
	private String content;
	private LocalDateTime postedOn;
	
	
	public MessageDtoFront() {
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
	
}
