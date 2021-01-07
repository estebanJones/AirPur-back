package fr.airpure.main.entities.echange;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


public class Departement {
	private String nom;
	private String numDep;
	/*
	//Entites simulés
	@ManyToOne
	private Region region;
	
	@OneToMany
	private Set<Commune> communes; 
	*/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumDep() {
		return numDep;
	}
	public void setNumDep(String numDep) {
		this.numDep = numDep;
	}
	
}
