package br.com.cpim.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpim.accessory.AccessoryService;
import br.com.cpim.integration.RentalAssembler;
import br.com.cpim.integration.RentalFormInput;
import br.com.cpim.model.Accessory;
import br.com.cpim.model.Rental;
import br.com.cpim.rental.RentalService;

/**
 * Classe responsável por atender às requisicoes Web via REST.
 * 
 * @author Roger
 *
 */
@RestController
@RequestMapping("/rental")
public class RentalController {
	
	@Inject
	private AccessoryService accessoryService;
	
	@Inject
	private RentalService rentalService;
	
	@Inject
	private RentalAssembler rentalAssembler;
	
	@RequestMapping(path="/accessories")
	public List<Accessory> allAccessories() {
		return accessoryService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<RentalFormInput> saveRental(@RequestBody @Valid final RentalFormInput formInput) {
		try {
			final Rental rental = rentalAssembler.toModel(formInput);
			Rental storedRental = rentalService.save(rental);
			
			RentalFormInput formInputResponse = rentalAssembler.fromModel(storedRental);
			
			return ResponseEntity.status(HttpStatus.OK).body(formInputResponse);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
