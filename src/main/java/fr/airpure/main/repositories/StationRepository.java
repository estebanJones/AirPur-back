package fr.airpure.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

}
