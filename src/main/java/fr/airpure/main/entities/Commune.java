package fr.airpure.main.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.airpure.main.entities.favoris.Favoris;

// TODO: Auto-generated Javadoc
/**
 * <b> Commune est la classe représentant la localité géographique, exemple: Montpellier.  </b>
 * <p>
 * Une commune est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un id (hérité de {@link Entite}) </li>
 * <li> Un nom de commune </li>
 * <li> Un code INSEE </li>
 * <li> Une population totale recensée </li>
 * <li> Un numéro de département </li>
 * </ul>
 * <p> Commune hérite de la superclasse {@link Entite} </p> 
 * <p> N Communes composent 1 {@link Departement} </p> 
 * @author Jeff
 *
 */
@Entity
public class Commune extends Entite {

	// PROPERTIES **************************************************************************************
	
	/**  Le nom de la commune. */
	@Column(name = "nom_commune")
	private String nomCommune;
	
	/** Le code INSEE affecté à la commune. */
	@Column(name = "code_insee")
	private String codeInseeCommune;
	
	/** La population totale recensee par l'INSEE. */
	@Column(name = "population_totale")
	private Integer populationTotaleCommune;
	
	/** Le département dans lequel se situe la commune. */
	@ManyToOne
	@JoinColumn(name="departement_id")
	private Departement departementCommune;

	/**  Le choix de commune  */
	@OneToMany(mappedBy= "commune") 
	private Set<Favoris> favoris = new HashSet<>();
	
	@OneToMany(mappedBy = "commune")
	Set<Station> stations = new HashSet<>();
	
	@OneToMany(mappedBy = "commune")
	Set<MeteoIndicateur> meteoIndicateurs = new HashSet<>();
	/**  coordonées à récupérés  */
	private double Longitude;
	
	private double Latitude;

	
	// CONSTRUCTEUR **************************************************************************************
	
	/**
	 * Instancie et retourne une Commune avec le nom , codeInsee et population fournis en paramètres
	 * Le département est lui instancié vide.
	 *
	 * @param nomCommune the nom commune
	 * @param codeInseeCommune the code insee commune
	 * @param populationTotaleCommune the population totale commune
	 */
	public Commune(String nomCommune, String codeInseeCommune, Integer populationTotaleCommune, double Longitude, double Latitude) {
		this.nomCommune = nomCommune;
		this.codeInseeCommune = codeInseeCommune;
		this.populationTotaleCommune = populationTotaleCommune;
		this.Longitude = Longitude;
		this.Latitude = Latitude;

	}
		
	
	/**
	 * Constructeur vide pour JPA.
	 */
	public Commune() {
	}

	// GETTERS & SETTERS **************************************************************************************

	/**
	 * Gets the nom commune.
	 *
	 * @return the nom commune
	 */
	public String getNomCommune() {
		return nomCommune;
	}

	
	/**
	 * Sets the nom commune.
	 *
	 * @param nomCommune the new nom commune
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}


	/**
	 * Gets the code insee commune.
	 *
	 * @return the code insee commune
	 */
	public String getCodeInseeCommune() {
		return codeInseeCommune;
	}

	/**
	 * Sets the code insee commune.
	 *
	 * @param codeInseeCommune the new code insee commune
	 */
	public void setCodeInseeCommune(String codeInseeCommune) {
		this.codeInseeCommune = codeInseeCommune;
	}
	
	
	/**
	 * Gets the population totale commune.
	 *
	 * @return the population totale commune
	 */
	public Integer getPopulationTotaleCommune() {
		return populationTotaleCommune;
	}


	/**
	 * Sets the population totale commune.
	 *
	 * @param populationTotaleCommune the new population totale commune
	 */
	public void setPopulationTotaleCommune(int populationTotaleCommune) {
		this.populationTotaleCommune = populationTotaleCommune;
	}
	
	
	/**
	 * Gets the departement commune.
	 *
	 * @return the departement commune
	 */
	public Departement getDepartementCommune() {
		return departementCommune;
	}

	
	/**
	 * Sets the departement commune.
	 *
	 * @param departementCommune the new departement commune
	 */
	public void setDepartementCommune(Departement departementCommune) {
		this.departementCommune = departementCommune;
	}
	
	public Set<Favoris> getFavoris() {
		return favoris;
	}


	public void setFavoris(Set<Favoris> favoris) {
		this.favoris = favoris;
	}


	public double getLongitude() {
		return Longitude;
	}


	public void setLongitude(double longitude) {
		Longitude = longitude;
	}


	public double getLatitude() {
		return Latitude;
	}


	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	
	// TOSTRING()  ******************************************************************************


	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String retour = "Nom Commune : " + this.nomCommune + "\n";
		retour += "ID Commune : " + this.getId() + "\n";
		retour += "Code INSEE Commune : " + this.codeInseeCommune + "\n";
		retour += "Departement : " + this.departementCommune.getNomDepartement() + " - " +  this.getDepartementCommune().getNumDepartement() + "\n";
		retour += "Region : " + this.departementCommune.getRegionDepartement().getNomRegion() + "\n";
		
		return retour;
	}


	
}
