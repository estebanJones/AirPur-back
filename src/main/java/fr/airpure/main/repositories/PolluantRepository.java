package fr.airpure.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.airpure.main.entities.Polluant;

public interface PolluantRepository extends JpaRepository<Polluant, Integer> {
	
	// LA QUERY QU ON VEUT MAIS NE MARCHE PAS
	@Query(value= "SELECT p.id, p.nom, p.valeur, p.unite, p.date_debut, p.date_fin, p.station_id FROM Polluant p WHERE p.station_id = :station_id "
			+ "GROUP BY p.nom, p.station_id, p.date_debut, p.date_fin, p.valeur ORDER BY MAX(p.date_fin) DESC LIMIT 20",
			nativeQuery= true)
	public List<Polluant> getDernierPolluantByStation(@Param("station_id") Integer idStation);
	
	
	
	// PAS LA QUERY A UTILISER MAIS ELLE MARCHE
	@Query(value= "SELECT polluant.id, polluant.nom, polluant.valeur, polluant.unite, MAX(polluant.date_debut) AS date_debut, polluant.date_fin, polluant.station_id "
			+ "FROM station INNER JOIN polluant ON station.id = :idStation GROUP BY station.id, polluant.nom",
			nativeQuery= true)
	public List<Polluant> test(@Param("idStation") Integer idStation);
}
