package fr.airpure.main.dto;

public class ResponseFavorisDto {
	private String message;

	public ResponseFavorisDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
