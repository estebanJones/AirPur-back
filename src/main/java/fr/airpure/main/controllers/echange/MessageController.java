package fr.airpure.main.controllers.echange;
/**
 * MessageController
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.services.echange.MessageService;
import fr.airpure.main.entities.echange.Message;

@RestController
@RequestMapping("/accueil/messages")
public class MessageController extends EchangeBasedController<Message, MessageService>{


}
