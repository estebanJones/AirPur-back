package fr.airpure.main.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The Class Polluant.
 */
@Entity
public class Polluant extends Entite {
	private String nom;
	private String symbole;
	private double valeur;
	private String unite;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	@ManyToOne
	@JoinColumn(name = "station_id")
	Station station;
	
	public Polluant() {
		// TODO Auto-generated constructor stub
	}
	
	public Polluant(String nom, String symbole, double valeur, String unite, LocalDateTime dateDebut,
			LocalDateTime dateFin, Station station) {
		this.nom = nom;
		this.symbole = symbole;
		this.valeur = valeur;
		this.unite = unite;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.station = station;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	
		
}
