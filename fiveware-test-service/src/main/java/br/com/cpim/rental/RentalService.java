package br.com.cpim.rental;

import org.springframework.stereotype.Service;

import br.com.cpim.model.Rental;

@Service
public interface RentalService {
	
	Rental save(Rental rental);
	
}
