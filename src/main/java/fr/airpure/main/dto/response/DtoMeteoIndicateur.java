cpackage fr.airpure.main.dto.response;

import java.time.LocalDateTime;

import fr.airpure.main.entities.MeteoIndicateur;

public class DtoMeteoIndicateur {
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
	
	public DtoMeteoIndicateur(MeteoIndicateur meteoIndicateur) {
		this.date = meteoIndicateur.getDate();
		this.vitesseMoyVent = meteoIndicateur.getVitesseMoyVent();
		this.cumulPluie = meteoIndicateur.getCumulPluie();
		this.tempatureSol = meteoIndicateur.getTempatureSol();
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
	
	
}
