package fr.airpure.main.repositories.echange;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.echange.Rubrique;

public interface RubriqueRepo extends JpaRepository<Rubrique, Integer>{
	public List<Rubrique> findByUtilisateurId(int utilisateurId);
	public List<Rubrique> findByUtilisateurPrenom(String utilisateurId);


}
