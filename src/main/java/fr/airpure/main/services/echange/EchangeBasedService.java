package fr.airpure.main.services.echange;

/**
 * echangeBasedService
 * Regroupe le CRUD generalise concernant toutes les classes filles
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.airpure.main.entities.echange.LongIdEntity;

public abstract class EchangeBasedService <T extends LongIdEntity, Repository extends JpaRepository<T, Integer>>{

	@Autowired
	protected Repository repository;
	
	public T create(T entity) {
		if (entity.getId() != null) {
			throw new RuntimeException("creation non permis!");
		}
		
		return repository.save(entity);
	}
	
	public T update(Integer id, T entity) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("update pas possible, element inexistant");
		}
		
		entity.setId(id);
		return repository.save(entity);
	}
	
	public void remove(Integer id) {
		repository.deleteById(id);
	}
	
	public T findById(Integer id) {
		 return repository.findById(id).orElse(null);
		
	}
	
	public List<T> findAll() {
		return repository.findAll();
	}
}
