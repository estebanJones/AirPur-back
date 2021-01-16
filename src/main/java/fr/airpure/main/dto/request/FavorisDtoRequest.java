package fr.airpure.main.dto.request;

import java.time.LocalDateTime;

import fr.airpure.main.entities.Commune;

public class FavorisDtoRequest {
	private Commune commune;
	private Boolean meteo;
	private Boolean air;
	private LocalDateTime ChoixDateDebut;
	private LocalDateTime ChoixDateFin;
	
	public FavorisDtoRequest(Commune commune, Boolean meteo, Boolean air, LocalDateTime choixDateDebut,
			LocalDateTime choixDateFin) {
		super();
		this.commune = commune;
		this.meteo = meteo;
		this.air = air;
		ChoixDateDebut = choixDateDebut;
		ChoixDateFin = choixDateFin;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
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
		return ChoixDateDebut;
	}

	public void setChoixDateDebut(LocalDateTime choixDateDebut) {
		ChoixDateDebut = choixDateDebut;
	}

	public LocalDateTime getChoixDateFin() {
		return ChoixDateFin;
	}

	public void setChoixDateFin(LocalDateTime choixDateFin) {
		ChoixDateFin = choixDateFin;
	}

}
