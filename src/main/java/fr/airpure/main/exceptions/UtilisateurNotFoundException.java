package fr.airpure.main.exceptions;

public class UtilisateurNotFoundException extends Exception {
	private String message;

	public UtilisateurNotFoundException(String message) {
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
