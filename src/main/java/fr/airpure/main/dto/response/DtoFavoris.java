package fr.airpure.main.dto.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.airpure.main.entities.MeteoIndicateur;
import fr.airpure.main.entities.Polluant;

public class DtoFavoris {
	private List<DtoMeteoIndicateur> dtosMeteoIndicateurs = new ArrayList<>();
	private List<DtoReleveStation> dtosRelevePolluants = new ArrayList<>();
	
	public DtoFavoris(List<MeteoIndicateur> meteoIndicateurs, List<Polluant> polluants) {
		super();
		 meteoIndicateurs.forEach(meteoIndicateur -> this.dtosMeteoIndicateurs.add(new DtoMeteoIndicateur(meteoIndicateur)));
		 
		 polluants.forEach(polluant -> this.dtosRelevePolluants.add(new DtoReleveStation(polluant)));
		 
	}

	public List<DtoMeteoIndicateur> getDtosMeteoIndicateurs() {
		return dtosMeteoIndicateurs;
	}

	public void setDtosMeteoIndicateurs(List<DtoMeteoIndicateur> dtosMeteoIndicateurs) {
		this.dtosMeteoIndicateurs = dtosMeteoIndicateurs;
	}

	public List<DtoReleveStation> getDtosRelevePolluants() {
		return dtosRelevePolluants;
	}

	public void setDtosRelevePolluants(List<DtoReleveStation> dtosRelevePolluants) {
		this.dtosRelevePolluants = dtosRelevePolluants;
	}
}
