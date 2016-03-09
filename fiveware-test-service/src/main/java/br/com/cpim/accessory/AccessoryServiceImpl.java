package br.com.cpim.accessory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.cpim.model.Accessory;
import br.com.cpim.repository.AccessoryRepository;

@Component
public class AccessoryServiceImpl implements AccessoryService {
	
	@Inject
	private AccessoryRepository repository;

	@Override
	public List<Accessory> findAll() {
		return repository.findAll();
	}

	@Override
	public Accessory find(Integer id) {
		return repository.getOne(id);
	}

}
