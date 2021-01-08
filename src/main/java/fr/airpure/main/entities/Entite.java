package fr.airpure.main.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// TODO: Auto-generated Javadoc
/**
 * <b>Entite est la classe abstraite représentant un objet persisté en base de donnée.</b>
 * <p>
 * Une Entite est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un identifiant unique attribué définitivement </li>
 * </ul>
 * 
 * <p> 
 * Toutes les classes du systèmes héritent de cette superclasse. 
 * </p>
 * @author Jeff
 *
 */
@MappedSuperclass
public abstract class Entite {

	// PROPERTIES **************************************************************************************
	
	/**
     * L'ID de l'Entite en BDD. Cet ID n'est pas modifiable.
     * 
     * @see Entite#getId()
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	// GETTERS AND SETTERS ******************************************************************************
	
	/**
    * Retourne l'ID de l'Entite.
    * 
    * @return L'identifiant en BDD de l'entite. 
    */
	public int getId() {
		return id;
	}	
}
