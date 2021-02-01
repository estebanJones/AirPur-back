
package fr.airpure.main.entities.echange;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.airpure.main.entities.Utilisateur;

@Entity
public class Suspension {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean definitif;
	
	// il faut une date de debut et une date de fin dans ce cas
	private Boolean temporaire;
	
	@ManyToOne
	private Utilisateur userAdmin;
	
	@OneToOne
	private Utilisateur userSuspendu;

	public Suspension() {
		super();
	}

	public Boolean getDefinitif() {
		return definitif;
	}

	public void setDefinitif(Boolean definitif) {
		this.definitif = definitif;
	}

	public Boolean getTemporaire() {
		return temporaire;
	}

	public void setTemporaire(Boolean temporaire) {
		this.temporaire = temporaire;
	}

	public Utilisateur getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(Utilisateur userAdmin) {
		this.userAdmin = userAdmin;
	}

	public Utilisateur getUserSuspendu() {
		return userSuspendu;
	}

	public void setUserSuspendu(Utilisateur userSuspendu) {
		this.userSuspendu = userSuspendu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
