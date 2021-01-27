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
	
	public Polluant(String nom, double valeur, String unite, LocalDateTime dateDebut,
			LocalDateTime dateFin) {
		this.nom = nom;
		this.valeur = valeur;
		this.unite = unite;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	@Override
	public String toString() {
		return "Polluant [nom=" + nom + ", valeur=" + valeur + ", unite=" + unite + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", station=" + station + "]";
	}	
}
