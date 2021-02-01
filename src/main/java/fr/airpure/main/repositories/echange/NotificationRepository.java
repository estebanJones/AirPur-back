package fr.airpure.main.repositories.echange;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.echange.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
	List<Notification> findByUtilisateurId(Integer utilisateurId);
}
