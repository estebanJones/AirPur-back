package fr.airpure.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.MeteoIndicateur;

public interface MeteoRepository extends JpaRepository<MeteoIndicateur, Integer> {

}
