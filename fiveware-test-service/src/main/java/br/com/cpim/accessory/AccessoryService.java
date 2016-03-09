package br.com.cpim.accessory;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cpim.model.Accessory;

/**
 * Interface para Accessory Service
 * 
 * @author Roger
 *
 */
@Service
public interface AccessoryService {

	List<Accessory> findAll();

	Accessory find(Integer integer);
	
}
