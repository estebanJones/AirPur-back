package fr.airpure.main.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.MeteoIndicateur;

public interface MeteoRepository extends JpaRepository<MeteoIndicateur, Integer> {

	public List<MeteoIndicateur> findByCommuneId (int idCommune);
	
	public Optional<MeteoIndicateur> findByDateAndCommuneId(LocalDateTime localDateTime, int idCommune);
}
