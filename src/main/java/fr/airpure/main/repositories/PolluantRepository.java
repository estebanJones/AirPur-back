package fr.airpure.main.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.airpure.main.entities.Polluant;

public interface PolluantRepository extends JpaRepository<Polluant, Integer> {
	
	@Query(value= "SELECT polluant.id, polluant.nom, polluant.valeur, polluant.unite, MAX(polluant.date_debut) AS date_debut, polluant.date_fin, polluant.station_id "
			+ "FROM polluant WHERE polluant.station_id = :idStation GROUP BY polluant.station_id, polluant.nom",
			nativeQuery= true)
	public List<Polluant> getDernierPolluantByStation(@Param("idStation") Integer idStation);
	
	@Query(value= "SELECT * FROM Polluant p WHERE p.station_id= :idStation AND p.nom= :nom AND p.date_Debut= :dateDebut", nativeQuery= true)
	public List<Polluant> findPolluantsByIdStationAndNomAndDateDebut(@Param("idStation") Integer idStation,@Param("nom") String nom, @Param("dateDebut") LocalDateTime dateDebut);

	public List<Polluant> findByDateDebutGreaterThanEqualAndDateFinLessThanEqualAndStationCommuneId(LocalDateTime dateDebut, LocalDateTime dateFin, Integer communeId);
	
	@Query(value="SELECT * FROM Polluant p WHERE p.station_id= :idStation AND p.date_debut >= :dateDebut AND p.date_fin <= :dateFin", nativeQuery= true)
	public List<Polluant> findPolluantsByDatesAndStationId(@Param("dateDebut")LocalDateTime dateDebut, @Param("dateFin") LocalDateTime dateFin,@Param("idStation") Integer idStation);
}
