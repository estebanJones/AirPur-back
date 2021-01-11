package fr.airpure.main.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

/**
 * The Class MeteoIndicateur.
 * Documentation des propriétés https://api.meteo-concept.com/documentation#forecast-map-day
 * Prévisions météo horaires ou tri-horaires
 */
@Entity
public class MeteoIndicateur extends Entite{
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
	
	@ManyToOne
	@JoinColumn(name="commune_id")
	private Commune commune;
	
	
	public MeteoIndicateur() {
		// TODO Auto-generated constructor stub
	}
	
	public MeteoIndicateur(LocalDateTime date, Integer vitesseMoyVent, double cumulPluie, Integer tempatureSol,
			Commune commune) {
		super();
		this.date = date;
		this.vitesseMoyVent = vitesseMoyVent;
		this.cumulPluie = cumulPluie;
		this.tempatureSol = tempatureSol;
		this.commune = commune;
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

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	
}
