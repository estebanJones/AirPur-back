package fr.airpure.main.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Message;
import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.repositories.UtilisateurRepository;
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
	private UtilisateurRepository utilisateurRepo;

	@BeforeEach
	void init() {
		/* réinitialisation des mocks */
		this.rubriqueService = mock(RubriqueService.class);
		this.rubriqueRepo = mock(RubriqueRepo.class);
		this.messageService = mock(MessageService.class);
		this.messageRepo = mock(MessageRepo.class);
		this.utilisateurRepo = mock(UtilisateurRepository.class);
	}

	@Test
	public void saveRubrique() throws Exception {
		/* creation du contexte */
		LocalDateTime now = LocalDateTime.now();

		/* creation du SUT */

		RubriqueService sut = new RubriqueService(this.rubriqueRepo, this.utilisateurRepo

		);

		// stubbing
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(1);
		utilisateur.setNom("nom1");
		utilisateur.setPrenom("prenom1");
		utilisateur.setEmail("email@gmail.com");
		utilisateur.setUsername("username1");
		utilisateur.setMotDePasse("mdp1");

		// setup mocking
		Rubrique rubrique = new Rubrique();
		rubrique.setId(1);
		rubrique.setContent("Contenue 1");
		rubrique.setDescription("description1");
		rubrique.setTitle("Titre1");

		// Appel de fonction d'intégration

		when(this.utilisateurRepo.getOne(utilisateur.getId())).thenReturn(utilisateur);

		when(this.rubriqueService.createRubrique(1, rubrique.getTitle(), rubrique.getDescription(),
				rubrique.getContent(), now)).thenReturn(new Rubrique());

		when(this.rubriqueRepo.save(rubrique)).thenReturn(new Rubrique());

		sut.saveRubrique(rubrique);

		// verifier resultat

		Mockito.verify(this.rubriqueRepo, times(1)).save(ArgumentMatchers.<Rubrique>any());

	}

	@Test
	public void testSaveMessage() throws Exception {
		/* creation du contexte */
		LocalDateTime now = LocalDateTime.now();

		/* creation du SUT */

		MessageService sut = new MessageService(this.rubriqueRepo, this.utilisateurRepo, this.messageRepo

		);

		// stubbing
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(1);
		utilisateur.setNom("nom1");
		utilisateur.setPrenom("prenom1");
		utilisateur.setEmail("email@gmail.com");
		utilisateur.setUsername("username1");
		utilisateur.setMotDePasse("mdp1");

		// setup mocking
		Rubrique rubrique = new Rubrique();
		rubrique.setId(1);
		rubrique.setContent("Contenue 1");
		rubrique.setDescription("description1");
		rubrique.setTitle("Titre1");

		// setup mocking
		Message message = new Message();
		message.setId(1);
		message.setContent("message1");

		// Appel de fonction d'intégration

		when(this.utilisateurRepo.getOne(utilisateur.getId())).thenReturn(utilisateur);

		when(this.rubriqueRepo.getOne(rubrique.getId())).thenReturn(rubrique);

		when(this.messageService.createMessage(utilisateur.getId(), rubrique.getId(), message.getContent(), now))
				.thenReturn(new Message());

		when(this.messageRepo.save(message)).thenReturn(new Message());

		sut.saveMessage(message);

		// verifier resultat

		Mockito.verify(this.messageRepo, times(1)).save(ArgumentMatchers.<Message>any());

	}

}
