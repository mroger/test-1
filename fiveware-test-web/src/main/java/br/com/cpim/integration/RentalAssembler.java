package br.com.cpim.integration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import br.com.cpim.accessory.AccessoryService;
import br.com.cpim.model.Accessory;
import br.com.cpim.model.Rental;

@Component
public class RentalAssembler {
	
	@Inject
	private AccessoryService accessoryService;

	public RentalFormInput fromModel(Rental rental) {
		RentalFormInput formInput = new RentalFormInput();
		formInput.setIdRental(rental.getIdRental());
		formInput.setBrand(rental.getBrand());
		formInput.setModel(rental.getModel());
		formInput.setYear(rental.getYear());
		formInput.setColor(rental.getColor());
		
		Function<Accessory, Integer> function = new Function<Accessory, Integer>() {
	        @Override
	        public Integer apply(Accessory accessory) {
	        	return accessory.getIdAccessory();
	        }
	    };
		List<Integer> accessoriesArray = Lists.transform(rental.getAccessories(), function);
		formInput.setAccessories(accessoriesArray.toArray(new Integer[0]));
		
		return formInput;
	}
	
	public Rental toModel(RentalFormInput formInput) {
		Rental rental = new Rental();
		rental.setBrand(formInput.getBrand());
		rental.setModel(formInput.getModel());
		rental.setYear(formInput.getYear());
		rental.setColor(formInput.getColor());
		rental.setAccessories(getAccessories(formInput));
		return rental;
	}

	private List<Accessory> getAccessories(RentalFormInput formInput) {
		List<Accessory> accessories = new ArrayList<>();
		Integer[] formAccessories = formInput.getAccessories();
		Accessory accessory;
		for (int i = 0; i < formAccessories.length; i++) {
			accessory = accessoryService.find(formAccessories[i]);
			accessories.add(accessory);
		}
		return accessories;
	}
	
}
