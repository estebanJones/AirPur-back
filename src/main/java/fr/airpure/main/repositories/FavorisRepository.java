package fr.airpure.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Favoris;

public interface FavorisRepository extends JpaRepository<Favoris, Integer>{

	public List<Favoris> findByCommuneId(int communeId);
}
