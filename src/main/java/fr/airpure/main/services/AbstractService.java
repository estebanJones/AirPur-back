package fr.airpure.main.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractService.
 */
@Service
public abstract class AbstractService {

	// PROPERTIES **************************************************************************************
	
	/** The em. */
	@PersistenceContext
	protected EntityManager em;
	
	// CONSTRUCTORS **************************************************************************************

	/**
	 * Instantiates a new abstract service.
	 */
	public AbstractService() {
		super();
	}
}
