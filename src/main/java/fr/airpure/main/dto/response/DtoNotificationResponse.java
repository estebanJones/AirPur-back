package fr.airpure.main.dto.response;

public class DtoNotificationResponse {
	private String message;
	
	public DtoNotificationResponse(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
