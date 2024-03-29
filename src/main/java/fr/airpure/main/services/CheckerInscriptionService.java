package fr.airpure.main.services;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.repositories.UtilisateurRepository;

@Service
public class CheckerInscriptionService {
	private UtilisateurRepository utilisateurRepository;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	
	CheckerInscriptionService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return (this.checkIfDtoIsNotBlank(dtoRequest) && 
				this.checkEmailSyntaxe(dtoRequest) 			&&
				this.checkIfUsernameNotExiste(dtoRequest)&&
			    this.checkIfEmailExiste(dtoRequest) &&
			    this.checkProprieteAdresse(dtoRequest))    ?  
					   true :  false;
	}
	

	public boolean checkIfEmailExiste(RegisterDtoRequest dtoRequest) {
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByEmail(dtoRequest.getEmail());
		if(utilisateur.isPresent()) {
			return false;
		}
		return true;
	}

	public boolean checkIfUsernameNotExiste(RegisterDtoRequest dtoRequest) {
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByUsername(dtoRequest.getUsername());

			return (!utilisateur.isPresent()) ? true : false;			
		
	}

	public boolean checkEmailSyntaxe(RegisterDtoRequest dtoRequest) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dtoRequest.getEmail());
        return matcher.find();
	}
	
	public boolean checkIfDtoIsNotBlank(RegisterDtoRequest dtoRequest) {
		if(!dtoRequest.getNom().isBlank() && 
		  !dtoRequest.getPrenom().isBlank() && !dtoRequest.getUsername().isBlank() &&
		  !dtoRequest.getEmail().isBlank() && !dtoRequest.getPassword().isBlank()) {
				
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkProprieteAdresse(RegisterDtoRequest dtoRequest) {
		if(!dtoRequest.getEmail().isBlank() && !dtoRequest.getNom().isBlank()
			&& !dtoRequest.getPrenom().isBlank() && !dtoRequest.getUsername().isBlank()
			&& !dtoRequest.getPassword().isBlank()) {	
				return true;
			}else {
				return false;
			}
	}
}
