package fr.airpure.main.exceptions.echange;

public class SuspensionNotFoundException extends Exception {
	private String message;

	public SuspensionNotFoundException(String message) {
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
