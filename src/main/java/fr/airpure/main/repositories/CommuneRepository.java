package fr.airpure.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	@Query( nativeQuery = true, value =
			"SELECT * FROM commune c  WHERE c.nom_commune LIKE :nomAlike")
	List<Commune> findByNomAlike(@Param("nomAlike") String nomAlike);
	
	@Query( nativeQuery = true, value = "DELETE FROM commune WHERE commune.id IN ( SELECT c.id FROM commune c JOIN departement d ON d.id = c.departement JOIN region r ON r.id = d.region_id WHERE r.id != 5")
	void deleteAllHorsOccitanie();

	
}
