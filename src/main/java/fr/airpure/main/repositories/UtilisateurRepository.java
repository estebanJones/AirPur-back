package fr.airpure.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByEmail(String email);
	public Optional<Utilisateur> findByUsername(String username);
}
