package fr.airpure.main.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.airpure.main.entities.MeteoIndicateur;

public interface MeteoRepository extends JpaRepository<MeteoIndicateur, Integer> {

	public List<MeteoIndicateur> findByCommuneId (int idCommune);
	

	public List<MeteoIndicateur> findByDateAndCommuneId(LocalDateTime localDateTime, int idCommune);

	@Query(value="SELECT * FROM meteo_indicateur WHERE meteo_indicateur.commune_id = :communeId ORDER BY meteo_indicateur.date DESC LIMIT 1", nativeQuery = true)
	public Optional<MeteoIndicateur> findLastMeteoByCommune(@Param ("communeId") Integer communeId);
	
	public List<MeteoIndicateur> findByDateBetweenAndCommuneIdOrderByDateDesc(LocalDateTime dateDebut, LocalDateTime dateFin, Integer communeId);
}
