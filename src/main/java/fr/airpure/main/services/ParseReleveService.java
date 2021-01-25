package fr.airpure.main.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Polluant;
import fr.airpure.main.exceptions.echange.NotFoundException;

@Service
public class ParseReleveService {
	private PolluantService polluantService;
	
	public ParseReleveService(PolluantService polluantService) {
		this.polluantService = polluantService;
	}
	
	public List<Polluant> parseReleve(Integer idStation) throws NotFoundException {
		
		List<Polluant> polluantsNonTrié = this.polluantService.getDernierPolluantByStation(idStation);
		polluantsNonTrié.stream().sorted((p1, p2) -> p1.getNom().compareTo(p2.getNom()));
       List<Polluant> listePolluantClean = new ArrayList<>();
//
//        boolean gazDejaAdd = false;
//
//        for(Polluant p : polluantsNonTrié) {
//            for (Polluant pV : listePolluantClean) {
//                if ( p.getNom() == pV.getNom()) {
//                        gazDejaAdd = true;
//                } else {
//                    if (p.getDateDebut() == pV.getDateDebut() ) {
//                        gazDejaAdd = true;
//                    }
//                }
//            }
//            if ( !gazDejaAdd ) {
//                 listePolluantClean.add(p);
//            }
//            gazDejaAdd = false;
//        }
//
        return listePolluantClean;
	}
	
}
