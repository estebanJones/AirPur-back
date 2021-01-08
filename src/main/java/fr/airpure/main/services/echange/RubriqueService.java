package fr.airpure.main.services.echange;
/**
 * RubriqueService
 */
import org.springframework.stereotype.Service;

import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.repositories.echange.RubriqueRepository;

@Service
public class RubriqueService extends EchangeBasedService<Rubrique,RubriqueRepository>{

}
