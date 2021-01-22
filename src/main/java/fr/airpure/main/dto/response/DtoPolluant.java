package fr.airpure.main.dto.response;

import java.time.LocalDateTime;

import fr.airpure.main.entities.Polluant;

public class DtoPolluant {
	private String nom;
	private double valeur;
	private String unite;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	public DtoPolluant(Polluant polluant) {
		super();
		this.nom = polluant.getNom();
		this.valeur = polluant.getValeur();
		this.unite = polluant.getUnite();
		this.dateDebut = polluant.getDateDebut();
		this.dateFin = polluant.getDateFin();
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
}
