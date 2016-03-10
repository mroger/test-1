package br.com.cpim.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cpim.accessory.AccessoryService;
import br.com.cpim.model.Accessory;
import br.com.cpim.model.Rental;

public class RentalAssemblerTest {
	
	@Mock
	private AccessoryService accessoryService;
	
	@InjectMocks
	private RentalAssembler rentalAssembler;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(accessoryService.find(1)).thenReturn(new Accessory(1));
		Mockito.when(accessoryService.find(2)).thenReturn(new Accessory(2));
		Mockito.when(accessoryService.find(3)).thenReturn(new Accessory(3));
		Mockito.when(accessoryService.find(4)).thenReturn(new Accessory(4));
	}
	

	@Test
	public void shouldConvertFormInputToModel() {
		RentalFormInput formInput = getNewRentalFormInput_1();
		
		Rental rentalConverted = rentalAssembler.toModel(formInput);
		
		assertThat("Should be equal", rentalConverted, equalTo(getNewRental_1()));
	}
	
	@Test
	public void shouldConvertModelToFormInput() {
		Rental rental = getNewRental_2();
		
		RentalFormInput formInputConverted = rentalAssembler.fromModel(rental);
		
		assertThat("Should be equal", formInputConverted, equalTo(getNewRentalFormInput_2()));
	}

	private Rental getNewRental_1() {
		Rental rental = new Rental();
		rental.setBrand(RENTAL_1.BRAND);
		rental.setModel(RENTAL_1.MODEL);
		rental.setYear(RENTAL_1.YEAR);
		rental.setColor(RENTAL_1.COLOR);
		rental.setAccessories(createAccessories(RENTAL_1.ACCESSORIES));
		return rental;
	}

	private Rental getNewRental_2() {
		Rental rental = new Rental();
		rental.setBrand(RENTAL_2.BRAND);
		rental.setModel(RENTAL_2.MODEL);
		rental.setYear(RENTAL_2.YEAR);
		rental.setColor(RENTAL_2.COLOR);
		rental.setAccessories(createAccessories(RENTAL_2.ACCESSORIES));
		return rental;
	}
	
	private RentalFormInput getNewRentalFormInput_1() {
		RentalFormInput formInput = new RentalFormInput();
		formInput.setBrand(RENTAL_1.BRAND);
		formInput.setModel(RENTAL_1.MODEL);
		formInput.setYear(RENTAL_1.YEAR);
		formInput.setColor(RENTAL_1.COLOR);
		formInput.setAccessories(RENTAL_1.ACCESSORIES);
		return formInput;
	}
	
	private RentalFormInput getNewRentalFormInput_2() {
		RentalFormInput formInput = new RentalFormInput();
		formInput.setBrand(RENTAL_2.BRAND);
		formInput.setModel(RENTAL_2.MODEL);
		formInput.setYear(RENTAL_2.YEAR);
		formInput.setColor(RENTAL_2.COLOR);
		formInput.setAccessories(RENTAL_2.ACCESSORIES);
		return formInput;
	}
	
	interface RENTAL_1 {
		String BRAND = "Chevrolet";
		String MODEL = "Camaro";
		String YEAR = "2015";
		Integer[] ACCESSORIES = {1, 3};
		String COLOR = "Amarelo";
	}
	
	interface RENTAL_2 {
		String BRAND = "Audi";
		String MODEL = "A3";
		String YEAR = "2013";
		Integer[] ACCESSORIES = {1, 2, 3, 4};
		String COLOR = "Preto";
	}
	
	private List<Accessory> createAccessories(Integer[] accessoriesArray) {
		List<Accessory> accessories = new ArrayList<>();
		for (int i = 0; i < accessoriesArray.length; i++) {
			Accessory accessory = new Accessory(accessoriesArray[i]);
			accessories.add(accessory);
		}
		return accessories;
	}
	
}
