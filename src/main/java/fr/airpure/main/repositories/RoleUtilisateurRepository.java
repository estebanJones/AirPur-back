package fr.airpure.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.RoleUtilisateur;

public interface RoleUtilisateurRepository extends JpaRepository<RoleUtilisateur, Integer> {

}
