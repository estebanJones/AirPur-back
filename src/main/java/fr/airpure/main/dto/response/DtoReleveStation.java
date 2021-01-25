package fr.airpure.main.dto.response;

import java.time.LocalDateTime;

import fr.airpure.main.entities.Polluant;

public class DtoReleveStation {
	private String nom;
	private double valeur;
	private String unite;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private Integer stationId;
	private String nomStation;
	private String nomCommune;
	
	public DtoReleveStation(Polluant polluant) {
		super();
		this.nom = polluant.getNom();
		this.valeur = polluant.getValeur();
		this.unite = polluant.getUnite();
		this.dateDebut = polluant.getDateDebut();
		this.dateFin = polluant.getDateFin();
		this.stationId = polluant.getStation().getId();
		this.nomStation = polluant.getStation().getNom();
		this.nomCommune = polluant.getStation().getCommune().getNomCommune();
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

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getNomStation() {
		return nomStation;
	}

	public void setNomStation(String nomStation) {
		this.nomStation = nomStation;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	
	
}
