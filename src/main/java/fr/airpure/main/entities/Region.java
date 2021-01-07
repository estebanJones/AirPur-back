package fr.airpure.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// TODO: Auto-generated Javadoc
/**
 * <b> Region est la classe représentant la localité géographique, exemple: Occitanie.  </b>
 * <p>
 * Une région est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un id (hérité de {@link Entite}) </li>
 * <li> Un nom de région </li>
 * <li> Un code INSEE de Region </li>
 * <li> Une liste de département qui la compose <li>
 * </ul>
 * <p> Departement hérite de la superclasse {@link Entite} </p> 
 * <p> 1 region contient N {@link Departement} </p>
 * @author Jeff
 *
 */
@Entity
public class Region extends Entite {
	
	// PROPERTIES **************************************************************************************
	
	/** Le nom de la region. */
	@Column(name = "nom")
	private String nomRegion;
	
	/** Le code region donnée par l'INSEE. */
	@Column(name = "code_region")
	private int codeRegion;
	
	/**   La liste des départements que contient la région. */
	@OneToMany(mappedBy="regionDepartement")
	private List<Departement> listeDepartementsRegion = new ArrayList<Departement>();

	// CONSTRUCTORS **************************************************************************************
	
	/**
	 * Instancie et retourne une region avec le nom et le code fournis en paramètres
	 * La liste des département est elle instanciée vide.
	 *
	 * @param nomRegion the nom region
	 * @param codeRegion the code region
	 */
	public Region(String nomRegion, int codeRegion) {
		super();
		this.nomRegion = nomRegion;
		this.codeRegion = codeRegion;
		this.listeDepartementsRegion = new ArrayList<Departement>();
	}
	
	/**
	 * Contruscteur vide pour JPA.
	 */
	public Region() {}
	

	/**
	 * Gets the nom region.
	 *
	 * @return the nom region
	 */
	// GETTERS AND SETTERS ******************************************************************************
	public String getNomRegion() {
		return nomRegion;
	}
	

	/**
	 * Sets the nom region.
	 *
	 * @param nomRegion the new nom region
	 */
	public void setNomRegion(String nomRegion) {
		this.nomRegion = nomRegion;
	}

	/**
	 * Gets the code region.
	 *
	 * @return the code region
	 */
	public int getCodeRegion() {
		return codeRegion;
	}

	/**
	 * Sets the code region.
	 *
	 * @param codeRegion the new code region
	 */
	public void setCodeRegion(int codeRegion) {
		this.codeRegion = codeRegion;
	}

	/**
	 * Gets the liste departements region.
	 *
	 * @return the liste departements region
	 */
	public List<Departement> getListeDepartementsRegion() {
		return listeDepartementsRegion;
	}

	/**
	 * Sets the liste departements region.
	 *
	 * @param listeDepartementsRegion the new liste departements region
	 */
	public void setListeDepartementsRegion(List<Departement> listeDepartementsRegion) {
		this.listeDepartementsRegion = listeDepartementsRegion;
	}
	
	// TOSTRING()  ******************************************************************************
	
		/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
			String retour = "Nom Region :" + this.nomRegion + "\n";
			retour += "ID Region:" + this.getId() + "\n";
			retour += "Code Region :" + this.codeRegion + "\n";
			retour += "Nombre de departements :" + this.listeDepartementsRegion.size() + "\n";
			
			return retour;
		}
		

	
	
	
	
	
}
