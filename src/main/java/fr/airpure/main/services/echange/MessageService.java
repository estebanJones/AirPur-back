package fr.airpure.main.services.echange;
/**
 * MessageService
 */
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.echange.Message;
import fr.airpure.main.repositories.echange.MessageRepository;

@Service
public class MessageService extends EchangeBasedService<Message, MessageRepository> {

}
