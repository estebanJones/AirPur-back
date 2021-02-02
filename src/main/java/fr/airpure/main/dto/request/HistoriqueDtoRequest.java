package fr.airpure.main.dto.request;

import java.time.LocalDateTime;

public class HistoriqueDtoRequest {

	private int idCommune;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	
	
	public HistoriqueDtoRequest(int idStation, LocalDateTime dateDebut, LocalDateTime dateFin) {
		super();
		this.idCommune = idStation;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	public int getIdStation() {
		return idCommune;
	}
	public void setIdStation(int idStation) {
		this.idCommune = idStation;
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
