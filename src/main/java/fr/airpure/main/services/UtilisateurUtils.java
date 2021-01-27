package fr.airpure.main.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import fr.airpure.main.dto.UtilisateurDto;
import fr.airpure.main.entities.Utilisateur;

public class UtilisateurUtils {
	@Autowired
    private ModelMapper modelMapper;
	//Methode de conversion de Entité vers Dto
		private UtilisateurDto convertToDto(Utilisateur utilisateur) {
			UtilisateurDto utilisateurDto = modelMapper.map(utilisateur, UtilisateurDto.class);
			return utilisateurDto;
		}

}
