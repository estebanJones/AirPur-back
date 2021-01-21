package fr.airpure.main.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.airpure.main.dto.RegisterDtoRequest;
import fr.airpure.main.repositories.UtilisateurRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
class CheckerInscriptionServiceTest{
	
	@Autowired
	private CheckerInscriptionService checkerInscriptionService;

	@Test
	void testCheckEmailSyntaxe() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("nom", "prenom", "username", "test.test@gmail.com", "password");
		boolean verification = this.checkerInscriptionService.checkEmailSyntaxe(dtoRequest);
		
		assertTrue(verification);
	}

	
	@Test
	void testCheckUneProprieteAdresseNotBlank() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("nom", "prenom", "username", "test.test@gmail.com", "password");
		boolean verification = this.checkerInscriptionService.checkProprieteAdresse(dtoRequest);
		
		assertTrue(verification);
	}
	
	@Test
	void testCheckUneProprieteAdresseBlank() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("nom", "prenom", "username", "test.test@gmail.com", "");
		boolean verification = this.checkerInscriptionService.checkProprieteAdresse(dtoRequest);
		
		assertFalse(verification);
	}
	
	@Test
	void testCheckDeuxProprieteAdresseBlank() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("nom", "prenom", "username", "", "");
		boolean verification = this.checkerInscriptionService.checkProprieteAdresse(dtoRequest);
		
		assertFalse(verification);
	}
	
	@Test
	void testCheckTroisProprieteAdresseBlank() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("nom", "prenom", "", "", "");
		boolean verification = this.checkerInscriptionService.checkProprieteAdresse(dtoRequest);
		
		assertFalse(verification);
	}
	
	@Test
	void testCheckQuatreProprieteAdresseBlank() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("nom", "", "", "", "");
		boolean verification = this.checkerInscriptionService.checkProprieteAdresse(dtoRequest);
		
		assertFalse(verification);
	}
	
	@Test
	void testCheckCinqProprieteAdresseBlank() {
		RegisterDtoRequest dtoRequest = new RegisterDtoRequest("", "", "", "", "");
		boolean verification = this.checkerInscriptionService.checkProprieteAdresse(dtoRequest);
		
		assertFalse(verification);
	}

}
