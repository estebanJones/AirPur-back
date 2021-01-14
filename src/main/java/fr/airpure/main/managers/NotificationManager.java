package fr.airpure.main.managers;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.airpure.main.dto.request.DtoNotificationRequest;
import fr.airpure.main.dto.response.DtoNotificationResponse;
import fr.airpure.main.entities.Departement;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Notification;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.services.DepartementService;
import fr.airpure.main.services.UtilisateurService;
import fr.airpure.main.services.echange.NotificationService;

@Component
public class NotificationManager {
	private DepartementService departementService;
	private UtilisateurService utilisateurService;
	private NotificationService notificationService;
	
	public NotificationManager(DepartementService departementService, UtilisateurService utilisateurService,
			NotificationService notificationService) {
		this.departementService = departementService;
		this.utilisateurService = utilisateurService;
		this.notificationService = notificationService;
	}


	public DtoNotificationResponse send(DtoNotificationRequest dtoNotificationRequest) throws NotFoundException {
		Departement departement = this.departementService.findByNom(dtoNotificationRequest.getNomDepartement());
		List<Utilisateur> allUtilisateurs = this.utilisateurService.getAllUtilisateurs();
		//Notification notification = new Notification(dtoNotificationRequest.getMessage(), allUtilisateurs, departement);
		return new DtoNotificationResponse("Notification envoyée avec succès.");
	}

}