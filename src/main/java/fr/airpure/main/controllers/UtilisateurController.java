package fr.airpure.main.controllers;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.dto.UpdatateDtoResponse;
import fr.airpure.main.dto.UtilisateurDto;
import fr.airpure.main.dto.UtilisateurWithPasswordDto;
import fr.airpure.main.entities.Utilisateur;
import fr.airpure.main.exceptions.UtilisateurNotFoundException;
import fr.airpure.main.exceptions.echange.ForbiddenException;
import fr.airpure.main.repositories.UtilisateurRepository;
import fr.airpure.main.services.UtilisateurService;
@RestController
@RequestMapping("accueil")
public class UtilisateurController {
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	/*
	 * Méthodes de Conversion de Entité -> Dto et Dto -> Entity Trouver une solution
	 * et le sortir du controller Interface fonctionnelle à cause du ::
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
	 * Affiche la liste des utilisateurs inscrits
	 */
	
	@GetMapping("/utilisateurs")
	@ResponseBody
	public List<UtilisateurDto> getListeUtilisateurs() {
		List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateurs();
		return utilisateurs.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	/*
	 * Affiche un utilisateur à partir de son id
	 */

	@GetMapping("utilisateur/{id}")
	@ResponseBody
	public UtilisateurDto getUnUtilisateur(@PathVariable("id") Integer id) throws UtilisateurNotFoundException {
		//Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.out.println("hello1 " + auth);	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println("hello" + currentPrincipalName );
		/*
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
		System.out.println(utilisateur);
		*/			
		return convertToDto(utilisateurService.getUtilisateur(id));
	}
	
	// Pour avoir le user connecté
	@GetMapping("/hello")
	public String hello(@CurrentSecurityContext(expression="authentication?.name")
	                    String username) {
	    return "Hello, " + username + "!";
	}

	@PutMapping(value = "updateUtilisateur/{id}")
	public ResponseEntity<?> updateUtilisateur(@RequestBody UtilisateurWithPasswordDto passwordDto)
			throws UtilisateurNotFoundException {
		Utilisateur utilisateur = convertToEntity(passwordDto);
		utilisateurService.updateUtilisateur(utilisateur);
		UpdatateDtoResponse reponseDto = new UpdatateDtoResponse("Utilisateur mis à jour");
		return ResponseEntity.ok(reponseDto);
	}

	// Coté front j'envoi un utilisateur

	// Cote je récupére l'ID

	// Avec le Principal je compare l'utilisateur connecté et celui en base

	// @PreAuthorize : pour donner l'accés à l'utilisateur connecté
	
	@PreAuthorize("@securityMethodsService.isConnectedUser(#id, principal)")
	public Utilisateur update(@PathVariable Integer id, @RequestBody Utilisateur entity) {
		return this.utilisateurService.update(id, entity);

	}

	@RequestMapping("/{id}/utilisateur")
	public Utilisateur update(@PathVariable Integer id, @RequestBody Utilisateur entity, Principal principal)
			throws UtilisateurNotFoundException {
		Utilisateur baseUser = utilisateurService.getUtilisateur(id);
		if (baseUser != null && principal.getName().equals(baseUser.getEmail())) {
			System.out.println(this.utilisateurService.update(id, entity));
			return this.utilisateurService.update(id, entity);
		} else {
			throw new ForbiddenException("l'utilisateur connecté ne correspond pas à l'utilisateur en BD");
		}
	}

	// Methode avoir supprimer un utilisateur
	@DeleteMapping("deleteUtilisateur/{id}")
	public void deleteUnUtilisateur(@PathVariable("id") Integer id) {
		this.utilisateurService.deleteUtilisateur(id);
	}

	/*
	 * @GetMapping("utilisateur/{id}") public Utilisateur
	 * getUnUtilisateur(@PathVariable("id") Integer id) throws
	 * UtilisateurNotFoundException { System.out.println("helooo1");
	 * System.out.println(SecurityContextHolder.getContext().getAuthentication());
	 * return null;
	 */
	// return this.utilisateurService.getUtilisateur(id);

	// Faire un webser

	/*
	 * //Methode update données de l'utilsateur
	 * 
	 * @PutMapping("updateUtilisateur") public ResponseEntity<?>
	 * updateUtilisateur(@RequestBody UpdateDto updateDto) { // Traitement Dto to
	 * Entity Utilisateur newUtilsateur =
	 * this.utilisateurRepository.getOne(updateDto.getID());
	 * newUtilsateur.setMotDePasse(updateDto.getPassword()); Utilisateur
	 * responseUtilisateurUpdate =
	 * this.utilisateurService.updateUtilisateur(newUtilsateur); // Le retour dans
	 * le front : ResponseEntity UpdatateDtoResponse reponseDto = new
	 * UpdatateDtoResponse("Utilisateur mis à jour"); return
	 * ResponseEntity.ok(reponseDto);
	 * 
	 * }
	 */

	// Methode update données de l'utilsateur
	/*
	 * @PutMapping("updateUtilisateur") public ResponseEntity<?>
	 * updatePassword(@RequestBody UpdateDto updateDto) { // Traitement Dto to
	 * Entity Utilisateur newUtilsateur =
	 * this.utilisateurRepository.getOne(updateDto.getID());
	 * newUtilsateur.setMotDePasse(updateDto.getPassword()); Utilisateur
	 * responseUtilisateurUpdate =
	 * this.utilisateurService.updateUtilisateur(newUtilsateur); //Utilisateur
	 * responseUtilisateurUpdate1 =
	 * this.utilisateurService.encodePassword(newUtilsateur.getMotDePasse()); // Le
	 * retour dans le front : ResponseEntity UpdatateDtoResponse reponseDto = new
	 * UpdatateDtoResponse("Utilisateur mis à jour"); return
	 * ResponseEntity.ok(reponseDto);
	 * 
	 * }
	 */

	// Méthode de modification du mot de passe pour l'utilisateur connecté

}
