package fr.airpure.main.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.airpure.main.dto.request.RegisterDtoRequest;
import fr.airpure.main.entities.echange.Notification;
import fr.airpure.main.entities.echange.Suspension;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String username;
	private String email;
	private String motDePasse;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
	private Set<RoleUtilisateur> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "utilisateur")
	private Set<Notification> notifications = new HashSet<>();
	
	@ManyToOne
	//@JoinTable(name = "utilisateur_id", inverseJoinColumns = @JoinColumn(name = "commune_id"))
	private Commune commune;
	
	@OneToMany(mappedBy = "utilisateur")
	private Set<Favoris> favoris;
	
	/**
	 * Relation entre Utilisateur et Suspendre
	 * un userAdmin peut suspendre plusieurs utilisateurs
	 * un utilisateur ne peut etre suspendu qu'une fois
	 */
	@OneToOne
	private Suspension suspendu;
	

	public Utilisateur(Integer id, String nom, String prenom, String username, String email, String motDePasse,
			Set<RoleUtilisateur> roles) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.motDePasse = motDePasse;
		this.roles = roles;
	}
	
	public Utilisateur(RegisterDtoRequest dtoRequest) {
		this.nom = dtoRequest.getNom();
		this.prenom = dtoRequest.getPrenom();
		this.username = dtoRequest.getUsername();
		this.email = dtoRequest.getEmail();
		this.motDePasse = dtoRequest.getPassword();
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMotDePasse() {
		return motDePasse;
	}


	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public Set<RoleUtilisateur> getRoles() {
		return roles;
	}


	public void setRoles(Set<RoleUtilisateur> roles) {
		this.roles = roles;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public Set<Favoris> getFavoris() {
		return favoris;
	}

	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}

	public Suspension getSuspendu() {
		return suspendu;
	}

	public void setSuspendu(Suspension suspendu) {
		this.suspendu = suspendu;
	}
	
	
}
