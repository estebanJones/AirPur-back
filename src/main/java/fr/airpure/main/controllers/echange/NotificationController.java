package fr.airpure.main.controllers.echange;
/**
 * NotificationController
 * Controleur spécifique aux notifications 
 */
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.request.DtoNotificationRequest;
import fr.airpure.main.dto.response.NotificationDtoResponse;
import fr.airpure.main.entities.echange.Notification;
import fr.airpure.main.exceptions.RequeteErreurException;
import fr.airpure.main.exceptions.echange.AlreadyExistsException;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.managers.NotificationManager;
import fr.airpure.main.repositories.echange.NotificationRepository;

@RestController
@RequestMapping("accueil")
public class NotificationController{
	@Autowired
	private NotificationRepository notificationRepository;
	private NotificationManager notificationManager;
	
	public NotificationController(NotificationManager notificationManager) {
		this.notificationManager = notificationManager;
	}
	
	@GetMapping
	public List<Notification> getAllNotifications() {
		return notificationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Notification getNotification(@PathVariable Integer id) {
		if(notificationRepository.findById(id).isPresent())
			return notificationRepository.findById(id).get();
		else return null;
	}
	
	/**
	 * 
	 * @param notification
	 * @return notification
	 * @throws AlreadyExistsException
	 */
	
	//@PreAuthorize("hasAuthority('NOTIF_CREATE')")
	@PostMapping("send")
	public ResponseEntity<?> sendNotification(@RequestBody DtoNotificationRequest dtoNotificationRequest, BindingResult resValid) throws AlreadyExistsException {
		if(!resValid.hasErrors()) {
			NotificationDtoResponse dtoNotificationResponse = null;
			try {
				dtoNotificationResponse = this.notificationManager.send(dtoNotificationRequest);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(dtoNotificationResponse);
		} else {
			return ResponseEntity.badRequest().body(new RequeteErreurException("Une erreur est survenue"));
		}
	}
	
	
	
	
	//@PreAuthorize("hasAuthority('NOTIF_DELETE')")
	@DeleteMapping("/{id}")
	public void deleteNotification(@PathVariable Integer id) throws NotFoundException {
		Notification existingNotification = notificationRepository.findById(id).orElseThrow(() -> new NotFoundException());
		notificationRepository.delete(existingNotification);
	}
	
	//@PreAuthorize("hasAuthority('NOTIF_UPDATE')")
	@PutMapping("/{id}")
	public Notification updateNotification(@PathVariable Integer id, @RequestBody Notification notification) throws NotFoundException {
		Optional<Notification> existingNotification = notificationRepository.findById(id);
		if (existingNotification.isPresent()) {
			notification.setId(id);
			return notificationRepository.save(notification);
		}
		
		throw new NotFoundException();
	}
	
}
