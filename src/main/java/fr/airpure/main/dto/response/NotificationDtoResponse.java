package fr.airpure.main.dto.response;

public class NotificationDtoResponse {
	private String message;
	
	public NotificationDtoResponse(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
