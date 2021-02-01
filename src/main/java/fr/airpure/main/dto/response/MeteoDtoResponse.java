package fr.airpure.main.dto.response;

import java.time.LocalDateTime;

import fr.airpure.main.entities.MeteoIndicateur;

public class MeteoDtoResponse {

	private int id;
	
	private LocalDateTime date;
	/**
	 * Vent moyen à 10 mètres en km/h
	 */
	private Integer vitesseMoyVent;
	/**
	 * 	Température du sol entre 10 et 40 cm en °C.
	 */
	private double cumulPluie;
	/**
	 * Température du sol entre 10 et 40 cm en °C.
	 */
	private Integer tempatureSol;
	
	private int idCommune;
	
	public MeteoDtoResponse(MeteoIndicateur meteoParam) {
		
		this.id = meteoParam.getId();
		this.date = meteoParam.getDate();
		this.vitesseMoyVent = meteoParam.getVitesseMoyVent();
		this.cumulPluie = meteoParam.getCumulPluie();
		this.tempatureSol = meteoParam.getTempatureSol();
		this.idCommune = meteoParam.getCommune().getId();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getVitesseMoyVent() {
		return vitesseMoyVent;
	}

	public void setVitesseMoyVent(Integer vitesseMoyVent) {
		this.vitesseMoyVent = vitesseMoyVent;
	}

	public double getCumulPluie() {
		return cumulPluie;
	}

	public void setCumulPluie(double cumulPluie) {
		this.cumulPluie = cumulPluie;
	}

	public Integer getTempatureSol() {
		return tempatureSol;
	}

	public void setTempatureSol(Integer tempatureSol) {
		this.tempatureSol = tempatureSol;
	}

	public int getIdCommune() {
		return idCommune;
	}

	public void setIdCommune(int idCommune) {
		this.idCommune = idCommune;
	}
	
	
}
