package fr.airpure.main.services.echange;
/**
 * NotificationService
 */
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.echange.Notification;
import fr.airpure.main.repositories.echange.NotificationRepository;

@Service
public class NotificationService extends EchangeBasedService<Notification, NotificationRepository>{

}
