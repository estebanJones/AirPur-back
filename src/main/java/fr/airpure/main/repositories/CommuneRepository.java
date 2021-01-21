package fr.airpure.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Region;

/**
 * The Interface CommuneRepository.
 */
public interface CommuneRepository extends JpaRepository<Commune, Integer>{
	
	Optional<Commune> findByCodeInseeCommune(String codeInsee);
	
	@Query(nativeQuery = true, value = 
		   " SELECT * FROM commune as C2 INNER JOIN departement ON C2.departement_id = departement.id INNER JOIN region ON region.id = departement.region_id  WHERE region.id = 5  ORDER BY C2.population_totale DESC LIMIT 0, 50")
	List<Commune> getTop50Population();
}
