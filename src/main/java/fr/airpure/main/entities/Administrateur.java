package fr.airpure.main.entities;

import java.util.Set;

import javax.persistence.OneToMany;

import fr.airpure.main.entities.echange.Suspension;

public class Administrateur extends Utilisateur{
	

	/**
	 * Relation entre Utilisateur et Suspendre
	 * un userAdmin peut suspendre plusieurs utilisateurs
	 * un utilisateur ne peut etre suspendu qu'une fois
	 */
	
	@OneToMany(mappedBy = "utilisateurs")
	private Set<Suspension> suspend;

	public Administrateur(Integer id, String nom, String prenom, String username, String email, String motDePasse,
			Set<RoleUtilisateur> roles, Set<Suspension> suspend) {
		super(id, nom, prenom, username, email, motDePasse, roles);
		this.suspend = suspend;
	}

	public Set<Suspension> getSuspend() {
		return suspend;
	}

	public void setSuspend(Set<Suspension> suspend) {
		this.suspend = suspend;
	}
	
	
}
