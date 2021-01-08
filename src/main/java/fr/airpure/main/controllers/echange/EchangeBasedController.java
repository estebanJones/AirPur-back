package fr.airpure.main.controllers.echange;
/**
 * echangeBasedController
 * Regroupe les methodes généralisés pour tous types d'échanges (rubrique et message)
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.airpure.main.entities.echange.LongIdEntity;
import fr.airpure.main.services.echange.EchangeBasedService;


@RestController
@RequestMapping("accueil")
public abstract class EchangeBasedController<T extends LongIdEntity, Service extends EchangeBasedService<T, ? extends JpaRepository<T, Integer>>> {
	
	@Autowired
	protected Service service;
	
	@PostMapping
	public T create(@RequestBody T entity) {
		return service.create(entity);
	}
	
	@PutMapping("/{id}")
	public T update(@PathVariable Integer id, @RequestBody T entity) {
		return service.update(id, entity);
	}
	
	@GetMapping("/{id}")
	public T find(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<T> findAll() {
		return service.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		service.remove(id);
	}
}
