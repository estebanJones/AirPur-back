package fr.airpure.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.airpure.main.entities.Polluant;
import fr.airpure.main.entities.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

	public List<Station> findByCommuneId(int commune_id);
	
	public Optional<Station> findByNom(String nomStation);
	
	@Query(value="SELECT * FROM polluant WHERE date_debut=(SELECT MAX(date_debut) from polluant WHERE station_id = ?1)",
			nativeQuery= true)
	public List<Polluant> findRelevesParStation(@Param("idStation") Integer idStation);
}

// "SELECT station.id, polluant.nom, MAX(polluant.date_debut) AS maxDate FROM `station` INNER JOIN polluant ON station.id = polluant.station_id WHERE polluant.station_id = :idStation GROUP BY station.id, polluant.nom "