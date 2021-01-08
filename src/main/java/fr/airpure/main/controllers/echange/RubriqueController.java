package fr.airpure.main.controllers.echange;
/**
 * RubriqueController
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.entities.echange.Rubrique;
import fr.airpure.main.services.echange.RubriqueService;



@RestController
@RequestMapping("/api/rubriques")
public class RubriqueController extends EchangeBasedController<Rubrique,RubriqueService>{

}
