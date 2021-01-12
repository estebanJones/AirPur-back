package fr.airpure.main.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.airpure.main.entities.Region;
import fr.airpure.main.exceptions.echange.NotFoundException;
import fr.airpure.main.repositories.RegionRepository;

/**
 * The Class RegionService.
 */
@Service
public class RegionService {
	private RegionRepository regionRepository;
	
	public RegionService(RegionRepository regionRepository) {
		this.regionRepository = regionRepository;
	}
	
	public Region findByCodeInsee(String codeInseeCommune) throws NotFoundException {
		Optional<Region> region = this.regionRepository.findByListeDepartementsRegionListeCommunesDepartementCodeInseeCommune(codeInseeCommune);
		if(region.isPresent()) {
			return region.get();
		} else {
			throw new NotFoundException();
		}
	}
}
