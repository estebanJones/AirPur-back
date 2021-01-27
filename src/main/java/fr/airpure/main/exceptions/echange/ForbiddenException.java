package fr.airpure.main.exceptions.echange;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "RENTRE CHEZ TOI")
public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 7790658418471325840L;

	public ForbiddenException() {
		super();
	}

	public ForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForbiddenException(String message) {
		super(message);
	}

	public ForbiddenException(Throwable cause) {
		super(cause);
	}
	
}
