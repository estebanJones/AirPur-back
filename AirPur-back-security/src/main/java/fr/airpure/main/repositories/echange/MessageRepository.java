package fr.airpure.main.repositories.echange;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.echange.Message;


public interface MessageRepository extends JpaRepository<Message, Long>{

}
