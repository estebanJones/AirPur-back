package fr.airpure.main.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
/**
 * FavorisClass
 * Determine le commune de choix de l'utilisateur 
 * l'affichage ou on de qu'elle type de mesure
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favoris {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	@ManyToOne
	private Commune commune;
	@ManyToOne
	private Utilisateur utilisateur;
	
	private boolean meteo;
	private boolean air;
	
	@Column()
	private LocalDateTime choixDateDebut;
	@Column()
	private LocalDateTime choixDateFin;
	
	
	// CONSTRUCTEURS
	public Favoris() {
		super();
	}

	
	// GETTERS & SETTERS
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


	public LocalDateTime getChoixDateDebut() {
		return choixDateDebut;
	}


	public void setChoixDateDebut(LocalDateTime choixDateDebut) {
		this.choixDateDebut = choixDateDebut;
	}


	public LocalDateTime getChoixDateFin() {
		return choixDateFin;
	}


	public void setChoixDateFin(LocalDateTime choixDateFin) {
		this.choixDateFin = choixDateFin;
	}

	
}
