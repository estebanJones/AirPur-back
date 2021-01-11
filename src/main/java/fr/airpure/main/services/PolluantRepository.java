package fr.airpure.main.services;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Polluant;

public interface PolluantRepository extends JpaRepository<Polluant, Integer> {

}
