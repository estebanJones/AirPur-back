package fr.airpure.main.exceptions.echange;

public class EchangeNotFoundException extends Exception {
	private String message;

	public EchangeNotFoundException(String message) {
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
