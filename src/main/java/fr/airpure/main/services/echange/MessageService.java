package fr.airpure.main.services.echange;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Message;
import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.exceptions.FavorisNotFoundException;
import fr.airpure.main.exceptions.echange.EchangeNotFoundException;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.repositories.echange.MessageRepo;
import fr.airpure.main.repositories.echange.RubriqueRepo;

@Service
public class MessageService {
	@Autowired
	private RubriqueRepo rubriqueRepo;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private MessageRepo messageRepo;

	/*
	 * Methode de création de Message
	 */
	public Message createMessage(Integer utilisateurId, Integer rubriqueId, String content, LocalDateTime postedOn) {
		Utilisateur utilisateur = this.utilisateurRepository.getOne(utilisateurId);
		Rubrique rubrique = this.rubriqueRepo.getOne(rubriqueId);
		Message nouveauMessage = new Message();
		nouveauMessage.setContent(content);
		nouveauMessage.setPostedOn(postedOn);
		nouveauMessage.setUtilisateur(utilisateur);
		nouveauMessage.setRubrique(rubrique);
		return nouveauMessage;
	}

	/*
	 * Methode de sauvegarde de Message
	 */

	public Message saveMessage(Message nouveauMessage) {
		return this.messageRepo.save(nouveauMessage);
	}

	public Message createAndSaveMessage(Integer utilisateurId, Integer rubriqueId, String content,
			LocalDateTime postedOn) {
		Message message = this.createMessage(utilisateurId, rubriqueId, content, postedOn);
		return this.saveMessage(message);
	}

	/*
	 * Methode de recupération de la liste des messages
	 */

	public List<Message> getTousLeMessages() {
		return this.messageRepo.findAll();
	}

	/*
	 * Methode de recupération de la liste des messages de la rubrique
	 */

	public List<Message> getMessagesRubrique(Integer rubriqueId) {
		return this.messageRepo.findByRubriqueId(rubriqueId);
	}

	/*
	 * Methode de recuperation de Favoris
	 */

	public Message getMessage(Integer id) throws EchangeNotFoundException {
		Optional<Message> optionalMessage = messageRepo.findById(id);

		if (!optionalMessage.isPresent()) {
			throw new EchangeNotFoundException("Message inexistant veuillé le créer...");
		}
		return optionalMessage.get();

	}

	/*
	 * Methode pour Supprimer un message
	 */
	public void deleteMessage(Integer id) {
		messageRepo.deleteById(id);
	}

	/*
	 * Methode Mise à jour de message
	 */
	// Methode Update 1
	public Message updateMessage(Message message) {
		return this.messageRepo.save(message);
	}
	/*
	 * public Message update(Integer id, Message message) { message.setId(id);
	 * return messageRepo.save(message); }
	 */
}
