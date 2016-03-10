package br.com.cpim.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import br.com.cpim.model.Accessory;
import br.com.cpim.model.Rental;
import test.br.com.cpim.main.DBTestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DBTestApplication.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class})
@Transactional
public class RentalRepositoryIT  {

	@Autowired
	private RentalRepository rentalRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void shouldCreateNewRental() {
		Rental newRental = getNewRental();
		
		Rental savedRental = rentalRepository.save(newRental);
		
		assertThat("Should not be null", savedRental.getIdRental(), notNullValue());
		
		Rental recoveredRental = rentalRepository.findOne(savedRental.getIdRental());
		
		assertThat("Should be equal", recoveredRental, equalTo(savedRental));
	}

	private Rental getNewRental() {
		Rental rental = new Rental();
		rental.setBrand(RENTAL_1.BRAND);
		rental.setModel(RENTAL_1.MODEL);
		rental.setYear(RENTAL_1.YEAR);
		rental.setColor(RENTAL_1.COLOR);
		rental.setAccessories(createAccessories(RENTAL_1.ACCESSORIES));
		return rental;
	}
	
	interface RENTAL_1{
		String BRAND = "Chevrolet";
		String MODEL = "Camaro";
		String YEAR = "2015";
		int[] ACCESSORIES = {1,3};
		String COLOR = "Amarelo";
	}
	
	private List<Accessory> createAccessories(int[] accessoriesArray) {
		List<Accessory> accessories = new ArrayList<>();
		for (int i = 0; i < accessoriesArray.length; i++) {
			Accessory accessory = new Accessory(accessoriesArray[i]);
			accessories.add(accessory);
		}
		return accessories;
	}
}
