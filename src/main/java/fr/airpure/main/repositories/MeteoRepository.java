package fr.airpure.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.airpure.main.entities.MeteoIndicateur;

public interface MeteoRepository extends JpaRepository<MeteoIndicateur, Integer> {

	public List<MeteoIndicateur> findByCommuneId (int idCommune);
	
	@Query(value="SELECT * FROM meteo_indicateur WHERE meteo_indicateur.commune_id = :communeId ORDER BY meteo_indicateur.date DESC LIMIT 1", nativeQuery = true)
	public Optional<MeteoIndicateur> findLastMeteoByCommune(Integer communeId);
}
