package fr.airpure.main.dto.request;

public class DtoNotificationRequest {
	private String message;
	private String codeDepartement;
	
	public DtoNotificationRequest(String message, String codeDepartement) {
		this.message = message;
		this.codeDepartement = codeDepartement;
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

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}


}
