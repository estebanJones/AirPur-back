package fr.airpure.main.services.echange;
/*
 * Service de CRUD pour une suspension
 */


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.entities.echange.Suspension;
import fr.airpure.main.exceptions.echange.SuspensionNotFoundException;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.repositories.echange.SuspensionRepository;

@Service
public class SuspensionService {
	private SuspensionRepository suspensionRepository;
	private UtilisateurRepository utilisateurRepository;
	
	public SuspensionService(SuspensionRepository suspensionRepository, UtilisateurRepository utilisateurRepository) {
		super();
		this.suspensionRepository = suspensionRepository;
		this.utilisateurRepository = utilisateurRepository;
	}
	
	
	/*
	 * Methode de création d'une suspension
	 */
	
	public Suspension createSuspension(Integer userAdminId, Integer userSuspenduId, Boolean definitif, Boolean temporaire) {
		Utilisateur userAdmin = this.utilisateurRepository.getOne(userAdminId);
		Utilisateur userSuspendu = this.utilisateurRepository.getOne(userSuspenduId);
		Suspension nouveauSuspension = new Suspension();
		nouveauSuspension.setUserAdmin(userAdmin);
		nouveauSuspension.setUserSuspendu(userSuspendu);
		nouveauSuspension.setDefinitif(definitif);
		nouveauSuspension.setTemporaire(temporaire);
		return nouveauSuspension;
		
	}
	/*
	 * Methode de sauvegarde de Suspension
	 */
	
	public Suspension saveSuspension(Suspension nouveauSuspension) {
		return this.suspensionRepository.save(nouveauSuspension);
	}
	
	public Suspension createAndSaveSuspension(Integer userAdminId,Integer userSuspenduId, Boolean definitif, Boolean temporaire){
		Suspension suspension = this.createSuspension(userAdminId, userSuspenduId, definitif, temporaire);
		return this.saveSuspension(suspension);
		
		
	}
	
	/*
	 * Methode de recupération de la liste des suspension
	 */
	public List<Suspension> getSuspensions() {
		return suspensionRepository.findAll();
	}
	
	/*
	 * Methode de recuperation d'une suspension
	 */
	public Suspension getSuspension(Integer id) throws SuspensionNotFoundException {
		Optional<Suspension> optionalSuspension = suspensionRepository.findById(id);

		if (!optionalSuspension.isPresent()) {
			throw new SuspensionNotFoundException("Suspension inexistant veuillé le créer...");
		}
		return optionalSuspension.get();
	}
	
	/*
	 * Methode pour Supprimer une suspension
	 */	
	public void deleteSuspension(Integer id) {
		suspensionRepository.deleteById(id);
	}
	
	/*
	 * Methode Mise à jour d'une suspension
	 */

	public Suspension updateListeSuspension(Integer id, Suspension suspension) {
		suspension.setId(id);
		return suspensionRepository.save(suspension);
	}
}
