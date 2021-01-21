package fr.airpure.main.services.echange;
/**
 * NotificationService
 */
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.echange.Notification;
import fr.airpure.main.repositories.echange.NotificationRepository;
//  extends EchangeBasedService<Notification, NotificationRepository>

@Service
public class NotificationService{
	private NotificationRepository notificationRepository;
	
	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}
	
	public Notification save(Notification notification) {
		return this.notificationRepository.save(notification);
	}
}
