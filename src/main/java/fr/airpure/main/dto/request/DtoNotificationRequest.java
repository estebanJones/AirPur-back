package fr.airpure.main.dto.request;

public class DtoNotificationRequest {
	private String message;
	private String nomDepartement;
	
	public DtoNotificationRequest(String message, String nomDepartement) {
		this.message = message;
		this.nomDepartement = nomDepartement;
	}

	public DtoNotificationRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
}
