package fr.airpure.main.repositories.echange;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.echange.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{

}
