package fr.airpure.main.controllers.echange;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.UpdatateDtoResponse;
import fr.airpure.main.dto.UtilisateurDto;
import fr.airpure.main.dto.UtilisateurWithPasswordDto;
import fr.airpure.main.dto.echange.MessageDto;
import fr.airpure.main.dto.echange.MessageDtoPost;
import fr.airpure.main.dto.response.FavorisDtoResponse;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Message;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;
import fr.airpure.main.exceptions.echange.EchangeNotFoundException;
import fr.airpure.main.services.UtilisateurService;
import fr.airpure.main.services.echange.MessageService;

@RestController
@RequestMapping("/accueil/messages")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ModelMapper modelMapper;

	/*
	 * Méthodes de Conversion de Entité -> Dto et Dto -> Entity Trouver une solution
	 * et le sortir du controller Interface fonctionnelle à cause du :: Pour Message
	 */

	private MessageDto convertToDto(Message message) {
		MessageDto messageDto = modelMapper.map(message, MessageDto.class);
		return messageDto;
	}

	private Message convertToEntity(MessageDto messageDto) throws EchangeNotFoundException {
		Message message = modelMapper.map(messageDto, Message.class);
		if (messageDto.getId() != null) {
			Message ancienMessage = messageService.getMessage(messageDto.getId());
		}
		return message;
	}

	/*
	 * Entity-Dto Pour Utilisateur
	 */

	private UtilisateurDto convertToDto(Utilisateur utilisateur) {
		UtilisateurDto utilisateurDto = modelMapper.map(utilisateur, UtilisateurDto.class);
		return utilisateurDto;
	}

	private Utilisateur convertToEntity(UtilisateurWithPasswordDto passwordDto) throws UtilisateurNotFoundException {
		Utilisateur utilisateur = modelMapper.map(passwordDto, Utilisateur.class);
		if (passwordDto.getId() != null) {
			Utilisateur ancienUtilisateur = utilisateurService.getUtilisateur(passwordDto.getId());
		}
		return utilisateur;
	}

	/*
	 * API POST pour ajouter un message
	 */

	@PostMapping
	public ResponseEntity<?> message(@RequestBody MessageDtoPost messageDtoPost, BindingResult requestValid) {
		if (!requestValid.hasErrors()) {
			this.messageService.createAndSaveMessage(messageDtoPost.getUtilisateurId(), messageDtoPost.getRubriqueId(),
					messageDtoPost.getContent(), messageDtoPost.getPostedOn());
			return ResponseEntity.ok(new FavorisDtoResponse("Message bien ajouté"));
		} else {
			return ResponseEntity.badRequest().body("Mauvaise Requete");
		}
	}

	/*
	 * API de GET de la liste de message total
	 */

	@GetMapping
	@ResponseBody
	public List<MessageDto> getListeMessage() {
		List<Message> messages = messageService.getTousLeMessages();
		return messages.stream().map(this::convertToDto).collect(Collectors.toList());

	}

	// Retourner la liste des messages contenu dans ce rubriqueId
	/*
	 * @GetMapping("{rubriqueId}") public List<Message> findByRubrique(@PathVariable
	 * Integer rubriqueId) { return this.messageRepo.findByRubriqueId(rubriqueId); }
	 */

	/*
	 * API de GET la liste des messages contenu dans ce rubriqueId
	 */

	@GetMapping("{rubriqueId}")
	public List<MessageDto> findByRubrique(@PathVariable Integer rubriqueId) {
		List<Message> messages = messageService.getMessagesRubrique(rubriqueId);
		return messages.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	/*
	 * API de GET la lsite des messages de l'utilisateur contenu dans ce rubriqueId
	 */

	/*
	 * @GetMapping("{/utilisateurId}") public List<MessageDtoFront>
	 * findByUtilisateur(@PathVariable Integer utilisateurId) { List<Message>
	 * message = messageService.getMessagesRubrique(utilisateurId); return
	 * message.stream().map(this::convertToDto).collect(Collectors.toList()); }
	 */

	/*
	 * API de UPDATE de message
	 */

	@PutMapping(value = "{id}")
	public ResponseEntity<?> update(@RequestBody MessageDto messageDto) throws EchangeNotFoundException {
		Message message = convertToEntity(messageDto);
		messageService.updateMessage(message);
		UpdatateDtoResponse responseDto = new UpdatateDtoResponse("Message mis à jour");
		return ResponseEntity.ok(responseDto);
	}

	/*
	 * API de suppresion
	 */

	@DeleteMapping("{id}")
	public void deleteUnMessage(@PathVariable("id") Integer id) {
		this.messageService.deleteMessage(id);
	}
}
