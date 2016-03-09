package br.com.cpim.rental;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.cpim.model.Rental;
import br.com.cpim.repository.RentalRepository;

/**
 * Classe responsavel por expor métodos do repositorio Rental.
 * 
 * @author Roger
 *
 */
@Component
public class RentalServiceImpl implements RentalService {

	@Inject
	private RentalRepository repository;

	/*
	 * (non-Javadoc)
	 * @see br.com.cpim.rental.RentalService#save(br.com.cpim.model.Rental)
	 */
	@Override
	public Rental save(Rental rental) {
		return repository.save(rental);
	}
	
}
