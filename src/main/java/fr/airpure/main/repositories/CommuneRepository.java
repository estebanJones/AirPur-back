package fr.airpure.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import fr.airpure.main.entities.Commune;

/**
 * The Interface CommuneRepository.
 */
public interface CommuneRepository extends JpaRepository<Commune, Integer>{
	
}
