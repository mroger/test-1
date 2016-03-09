package br.com.cpim.rental;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.cpim.model.Rental;
import br.com.cpim.repository.RentalRepository;

@Component
public class RentalServiceImpl implements RentalService {

	@Inject
	private RentalRepository repository;

	@Override
	public Rental save(Rental rental) {
		return repository.save(rental);
	}
	
}
