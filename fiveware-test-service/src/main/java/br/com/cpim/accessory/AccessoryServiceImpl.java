package br.com.cpim.accessory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.cpim.model.Accessory;
import br.com.cpim.repository.AccessoryRepository;

/**
 * Classe responsavel por expor métodos do repositorio Accessory.
 * 
 * @author Roger
 *
 */
@Component
public class AccessoryServiceImpl implements AccessoryService {
	
	@Inject
	private AccessoryRepository repository;

	/*
	 * (non-Javadoc)
	 * @see br.com.cpim.accessory.AccessoryService#findAll()
	 */
	@Override
	public List<Accessory> findAll() {
		return repository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.cpim.accessory.AccessoryService#find(java.lang.Integer)
	 */
	@Override
	public Accessory find(Integer id) {
		return repository.getOne(id);
	}

}
