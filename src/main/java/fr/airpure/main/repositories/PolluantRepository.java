package fr.airpure.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.airpure.main.entities.Polluant;

public interface PolluantRepository extends JpaRepository<Polluant, Integer> {
	
	@Query(value= "SELECT polluant.id, polluant.nom, polluant.valeur, polluant.unite, MAX(polluant.date_debut) AS date_debut, polluant.date_fin, polluant.station_id "
			+ "FROM polluant WHERE polluant.station_id = :idStation GROUP BY polluant.station_id, polluant.nom",
			nativeQuery= true)
	public List<Polluant> getDernierPolluantByStation(@Param("idStation") Integer idStation);
	
}
