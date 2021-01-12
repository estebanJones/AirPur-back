package fr.airpure.main.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Station extends Entite{
	private String nom;
	private String latitude;
	private String longitude;
	
	@ManyToOne
	@JoinColumn(name = "commune_id")
	Commune commune;
	
	@OneToMany(mappedBy = "station")
	Set<Polluant> polluant = new HashSet<>();
	
	public Station() {
		// TODO Auto-generated constructor stub
	}

	public Station(String nom, String latitude, String longitude) {
		super();
		this.nom = nom;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public Set<Polluant> getPolluant() {
		return polluant;
	}

	public void setPolluant(Set<Polluant> polluant) {
		this.polluant = polluant;
	}
	
	
}
