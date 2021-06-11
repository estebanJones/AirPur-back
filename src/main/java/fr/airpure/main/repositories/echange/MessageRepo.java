package fr.airpure.main.repositories.echange;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.airpure.main.entities.echange.Message;
import fr.airpure.main.entities.echange.Rubrique;

public interface MessageRepo extends JpaRepository<Message, Integer>{
	public List<Message> findByRubriqueId(int rubriqueId);
	public List<Message> findByUtilisateurId(int utilisateurId);
	public List<Message> findByUtilisateurPrenomOrderById(String utilisateurPrenom);

	
	
}
