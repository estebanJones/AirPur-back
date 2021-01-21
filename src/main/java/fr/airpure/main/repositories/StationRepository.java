package fr.airpure.main.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

	public List<Station> findByCommuneId(int commune_id);
	
	public Optional<Station> findByNom(String nomStation);
}
