package fr.airpure.main.dto.request;

import fr.airpure.main.entities.Departement;

public class DtoDepartement {
	private Integer id;
	private String nomDepartement;
	private String codeDepartement;
	
	public DtoDepartement(Departement departement) {
		this.id = departement.getId();
		this.nomDepartement = departement.getNomDepartement();
		this.codeDepartement = departement.getCodeDepartement();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
}
