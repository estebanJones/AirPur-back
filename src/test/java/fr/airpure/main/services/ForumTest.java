package fr.airpure.main.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Message;
import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.repositories.echange.MessageRepo;
import fr.airpure.main.repositories.echange.RubriqueRepo;
import fr.airpure.main.services.echange.MessageService;
import fr.airpure.main.services.echange.RubriqueService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ForumTest {

	private RubriqueService rubriqueService;
	private MessageService messageService;
	private RubriqueRepo rubriqueRepo;
	private MessageRepo messageRepo;

	@BeforeEach
	void init() {
		/* réinitialisation des mocks */
		this.rubriqueService = mock(RubriqueService.class);
		this.rubriqueRepo = mock(RubriqueRepo.class);
		this.messageService = mock(MessageService.class);
		this.messageRepo = mock(MessageRepo.class);
	}

	@Test
	public void testSaveMessage() throws Exception {
		/* creation du contexte */
		LocalDateTime now = LocalDateTime.now();

		// stubbing
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(1);

		Rubrique rubrique = new Rubrique();
		rubrique.setId(1);
		rubrique.setContent("Contenue 1");
		rubrique.setDescription("description1");
		rubrique.setTitle("Titre1");

		// setup mocking
		Message message = new Message();
		message.setId(1);
		message.setContent("message1");
		message.setRubrique(rubrique);

		when(this.messageService.createMessage(utilisateur.getId(), rubrique.getId(), message.getContent(), now))
				.thenReturn(new Message());

		// ArgumentCaptor<Message> argument1 = ArgumentCaptor.forClass(Message.class);

		Mockito.verify(this.messageService, times(1)).createMessage(utilisateur.getId(), rubrique.getId(),
				message.getContent(), now);

		// Mockito.verify(this.messageService,
		// times(1)).createMessage(argument1.capture());

		// verify(petApi, times(1)).addPet(argument1.capture());
	}

	@Test
	public void saveRubrique() throws Exception {
		/* creation du contexte */
		LocalDateTime now = LocalDateTime.now();

		// stubbing
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(1);

		// setup mocking
		Rubrique rubrique = new Rubrique();
		rubrique.setId(1);
		rubrique.setContent("Contenue 1");
		rubrique.setDescription("description1");
		rubrique.setTitle("Titre1");

		when(this.rubriqueService.createRubrique(1, rubrique.getTitle(), rubrique.getDescription(),
				rubrique.getContent(), now)).thenReturn(new Rubrique());

		// Mockito.verify(this.rubriqueService, times(1)).createRubrique(1,
		// rubrique.getTitle(), rubrique.getDescription(),
		// rubrique.getContent(), now);

		Mockito.verify(this.rubriqueService, never()).createRubrique(1, rubrique.getTitle(), rubrique.getDescription(),
				rubrique.getContent(), now);

	}

}
