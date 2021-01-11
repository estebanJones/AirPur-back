package fr.airpure.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Commune;
import fr.airpure.main.entities.Region;

/**
 * The Interface CommuneRepository.
 */
public interface CommuneRepository extends JpaRepository<Commune, Integer>{
	Optional<Commune> findByCodeInseeCommune(String codeInsee);

}
