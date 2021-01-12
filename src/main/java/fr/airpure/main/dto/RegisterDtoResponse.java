package fr.airpure.main.dto;

public class RegisterDtoResponse {
	private String message;

	public RegisterDtoResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public RegisterDtoResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
