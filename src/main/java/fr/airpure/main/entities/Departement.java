package fr.airpure.main.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.airpure.main.entities.echange.Notification;
import net.bytebuddy.build.ToStringPlugin;

// TODO: Auto-generated Javadoc
/**
 * <b> Departement est la classe représentant la localité géographique, exemple: Herault.  </b>
 * <p>
 * Un département est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un id (hérité de {@link Entite}) </li>
 * <li> Un nom de département </li>
 * <li> Un numéro de département </li>
 * <li> La région du département </li>
 * </ul>
 * <p> Departement hérite de la superclasse {@link Entite} </p> 
 * <p> 1 département contient N {@link Commune} </p>
 * <p> N département composent 1 {@link Region} </p> 
 * @author Jeff
 *
 */
@Entity
public class Departement extends Entite {

	// PROPERTIES **************************************************************************************
	
	/** Le nom du département. */
	@Column(name = "date_maj")
	private String nomDepartement;
	
	/** Le numero du département. */
	@Column(name = "code_departement")
	private String codeDepartement;
	
	/** La région du département. */
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region regionDepartement;
	
	/** La liste des communes du departement. */
	@OneToMany
	@JoinColumn(name="departement_id")
	private List<Commune> listeCommunesDepartement = new ArrayList<Commune>();
	
	/** La liste des notification qui concerne le departement. */

	@OneToMany(mappedBy = "departement")
	private List<Notification> notifications = new ArrayList<>();

	// CONSTRUCTOR **************************************************************************************
	
	/**
	 * Instancie et retourne un département avec le nom et le numéro fourni en paramètre.
	 * La région est elle instancié comme vide.
	 * La liste des commune est elle instanciée vide.
	 *
	 * @param codeDepartement the num departement
	 * @param nomDepartement the nom departement
	 */
	public Departement(String codeDepartement, String nomDepartement) {
		super();
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
	}
	
	/**
	 * Constructeur vide pour JPA.
	 */
	public Departement() {}
	

	// GETTERS AND SETTERS ******************************************************************************

	/**
	 * Gets the num departement.
	 *
	 * @return the num departement
	 */
	public String getNumDepartement() {
		return codeDepartement;
	}

	/**
	 * Sets the num departement.
	 *
	 * @param codeDepartement the new num departement
	 */
	public void setNumDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * Gets the nom departement.
	 *
	 * @return the nom departement
	 */
	public String getNomDepartement() {
		return nomDepartement;
	}

	/**
	 * Sets the nom departement.
	 *
	 * @param nomDepartement the new nom departement
	 */
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	/**
	 * Gets the region departement.
	 *
	 * @return the region departement
	 */
	public Region getRegionDepartement() {
		return regionDepartement;
	}

	/**
	 * Sets the region departement.
	 *
	 * @param regionDepartement the new region departement
	 */
	public void setRegionDepartement(Region regionDepartement) {
		this.regionDepartement = regionDepartement;
	}

	/**
	 * Gets the liste communes departement.
	 *
	 * @return the liste communes departement
	 */
	public List<Commune> getListeCommunesDepartement() {
		return listeCommunesDepartement;
	}

	/**
	 * Sets the liste communes departement.
	 *
	 * @param listeCommunesDepartement the new liste communes departement
	 */
	public void setListeCommunesDepartement(List<Commune> listeCommunesDepartement) {
		this.listeCommunesDepartement = listeCommunesDepartement;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public List<Notification> getNotifications() {
		return notifications;
	}
	
	/**
	 * 
	 * @param notifications
	 */
	
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	// TOSTRING()  ******************************************************************************
	

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String retour = "Nom Departement : " + this.nomDepartement + "\n";
		retour += "ID Departement:" + this.getId() + "\n";
		retour += "Numero Departement : " + this.codeDepartement + "\n";
		retour += "Nombre de communes : " + this.listeCommunesDepartement.size() + "\n";
		retour += "Region :" + this.regionDepartement.getNomRegion() + "\n";
		
		return retour;
	}
	

}
