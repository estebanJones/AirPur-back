package fr.airpure.main.dto.request;

import java.time.LocalDateTime;

import fr.airpure.main.entities.Commune;


public class FavorisDtoRequest {
	private Commune commune;
	private Boolean meteo;
	private Boolean air;
	private LocalDateTime choixDateDebut;
	private LocalDateTime choixDateFin;
	private Integer utilisateurId;
	

	public FavorisDtoRequest(Commune commune, Boolean meteo, Boolean air, LocalDateTime choixDateDebut,
			LocalDateTime choixDateFin) {
		super();
		this.communeId = communeId;
		this.meteo = meteo;
		this.air = air;
		this.choixDateDebut = choixDateDebut;
		this.choixDateFin = choixDateFin;
		this.utilisateurId = utilisateurId;
	}


	public Integer getCommuneId() {
		return communeId;
	}


	public void setCommuneId(Integer communeId) {
		this.communeId = communeId;
	}


	public Boolean getMeteo() {
		return meteo;
	}


	public void setMeteo(Boolean meteo) {
		this.meteo = meteo;
	}


	public Boolean getAir() {
		return air;
	}


	public void setAir(Boolean air) {
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


	public Integer getUtilisateurId() {
		return utilisateurId;
	}


	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}


}
