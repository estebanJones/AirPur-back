package fr.airpure.main.dto.response;

import java.time.LocalDate;

import fr.airpure.main.entities.echange.Notification;

public class NotificationDtoListe {
	private Integer id;
	private String message;
	private String codeDepartement;
	private String userNameEmetteur;
	private LocalDate dateCreation;
	
	public NotificationDtoListe(Notification notification) {
		this.id = notification.getId();
		this.message = notification.getMessage();
		this.codeDepartement = notification.getDepartement().getCodeDepartement();
		this.userNameEmetteur = notification.getUtilisateur().getUsername();
		this.dateCreation = notification.getDateCreation();
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUserNameEmetteur() {
		return userNameEmetteur;
	}

	public void setUserNameEmetteur(String userNameEmetteur) {
		this.userNameEmetteur = userNameEmetteur;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
}
