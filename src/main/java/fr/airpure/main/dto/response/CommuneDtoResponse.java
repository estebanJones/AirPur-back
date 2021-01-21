package fr.airpure.main.dto.response;

import java.util.ArrayList;
import java.util.List;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Favoris;
import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.entities.Station;

/**
 * DTO permettant de communiquer les informations essentielles d'une commune vers le Front-End
 * @author Exost
 *
 */
public class CommuneDtoResponse {

	private String nomCommune;
	
	private String codeInseeCommune;
	
	private int populationTotaleCommune;
	
	private int idDepartementCommune;
	
	private List<Integer> listeIdStationsCommune = new ArrayList<Integer>();
	
	private List<Integer> listeIdMeteoIncateurCommune =  new ArrayList<Integer>();
	
	private List<Integer> listeIdFavorisCommune =  new ArrayList<Integer>();
	
	
	public CommuneDtoResponse(Commune communeParam) {
		
		this.nomCommune = communeParam.getNomCommune();
		
		this.codeInseeCommune = communeParam.getCodeInseeCommune();
		
		this.populationTotaleCommune = communeParam.getPopulationTotaleCommune();
		
		this.idDepartementCommune = communeParam.getDepartementCommune().getId();
		
		System.out.println("Size Liste Station = " + communeParam.getStations().size());
		for (Station s : communeParam.getStations() ) {
			this.listeIdStationsCommune.add(s.getId());
		}
		
		for (MeteoIndicateur m : communeParam.getMeteoIndicateurs() ) {
			this.listeIdMeteoIncateurCommune.add(m.getId());
		}
		
		
		for (Favoris f : communeParam.getFavoris() ) {
			this.listeIdFavorisCommune.add(f.getId());
		}
		
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodeInseeCommune() {
		return codeInseeCommune;
	}

	public void setCodeInseeCommune(String codeInseeCommune) {
		this.codeInseeCommune = codeInseeCommune;
	}

	public int getPopulationTotaleCommune() {
		return populationTotaleCommune;
	}

	public void setPopulationTotaleCommune(int populationTotaleCommune) {
		this.populationTotaleCommune = populationTotaleCommune;
	}

	public int getIdDepartementCommune() {
		return idDepartementCommune;
	}

	public void setIdDepartementCommune(int idDepartementCommune) {
		this.idDepartementCommune = idDepartementCommune;
	}

	public List<Integer> getListeIdStationsCommune() {
		return listeIdStationsCommune;
	}

	public void setListeIdStationsCommune(List<Integer> listeIdStationsCommune) {
		this.listeIdStationsCommune = listeIdStationsCommune;
	}

	public List<Integer> getListeIdMeteoIncateurCommune() {
		return listeIdMeteoIncateurCommune;
	}

	public void setListeIdMeteoIncateurCommune(List<Integer> listeIdMeteoIncateurCommune) {
		this.listeIdMeteoIncateurCommune = listeIdMeteoIncateurCommune;
	}

	public List<Integer> getListeIdFavorisCommune() {
		return listeIdFavorisCommune;
	}

	public void setListeIdFavorisCommune(List<Integer> listeIdFavorisCommune) {
		this.listeIdFavorisCommune = listeIdFavorisCommune;
	}
	
	

	
}
