package fr.airpure.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Region;


/**
 * The Interface RegionRepository.
 */
public interface RegionRepository extends JpaRepository<Region, Integer>{
	Optional<Region> findByListeDepartementsRegionListeCommunesDepartementCodeInseeCommune(String codeInseeCommune);
}
