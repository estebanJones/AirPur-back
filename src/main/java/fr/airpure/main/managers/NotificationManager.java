package fr.airpure.main.managers;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.airpure.main.dto.request.DtoNotificationRequest;
import fr.airpure.main.dto.response.NotificationDtoResponse;
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

	public NotificationDtoResponse send(DtoNotificationRequest dtoNotificationRequest) throws NotFoundException {
		Departement departement = this.departementService.findByCodeDepartement(dtoNotificationRequest.getCodeDepartement());
		List<Utilisateur> allUtilisateurs = this.utilisateurService.getAllUtilisateurs();
		allUtilisateurs.forEach(utilisateur -> {
			this.notificationService.save(new Notification(dtoNotificationRequest.getMessage(), utilisateur, departement, false));
		});
		return new NotificationDtoResponse("Notification envoyée avec succès.");
	}
}
