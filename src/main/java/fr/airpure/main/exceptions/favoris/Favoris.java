package fr.airpure.main.exceptions.favoris;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * FavorisClass
 * Determine le commune de choix de l'utilisateur 
 * l'affichage ou on de qu'elle type de mesure
 */
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Utilisateur;
@Entity
public class Favoris {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	//@OneToMany
	@ManyToOne
	//private Set<Commune> communes = new HashSet<>();
	private Commune commune;
	@ManyToOne
	private Utilisateur utilisateur;
	
	private boolean meteo;
	private boolean air;
	private boolean recensement;
	// CONSTRUCTEURS
	public Favoris() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Commune getCommune() {
		return commune;
	}
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public boolean isMeteo() {
		return meteo;
	}
	public void setMeteo(boolean meteo) {
		this.meteo = meteo;
	}
	public boolean isAir() {
		return air;
	}
	public void setAir(boolean air) {
		this.air = air;
	}
	public boolean isRecensement() {
		return recensement;
	}
	public void setRecensement(boolean recensement) {
		this.recensement = recensement;
	}
	
	
	
}
