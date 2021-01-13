package fr.airpure.main.dto.response;

public class ResponseSuspensionDto {
private String message;

public ResponseSuspensionDto(String message) {
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
