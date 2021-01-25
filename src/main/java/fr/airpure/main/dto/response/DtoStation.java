package fr.airpure.main.dto.response;

import java.util.HashSet;
import java.util.Set;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Polluant;
import fr.airpure.main.entities.Station;

public class DtoStation {
	// COMMENT FAIRE POUR PASSER LES OBJETS
	// JE PEUX FAIRE DES PROPRIETES STANDARD MAIS
	// POLLUANT DEVRA FORCEMENT ETRE UN TABLEAU
	private Integer id;
	private String nom;
	private Double latitude;
	private Double longitude;
	private String nomCommune;
	private Set<DtoPolluant> polluant = new HashSet<>();
	
	public DtoStation(Station station) {
		super();
		this.id = station.getId();
		this.nom = station.getNom();
		this.latitude = Double.parseDouble(station.getLatitude());
		this.longitude = Double.parseDouble(station.getLongitude());
		this.nomCommune = station.getCommune().getNomCommune();
		
		station.getPolluant().forEach(polluant -> {
			this.polluant.add(new DtoPolluant(polluant));
		});
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public Set<DtoPolluant> getPolluant() {
		return polluant;
	}

	public void setPolluant(Set<DtoPolluant> polluant) {
		this.polluant = polluant;
	}
}
