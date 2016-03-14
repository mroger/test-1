package br.com.cpim.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import br.com.cpim.Application;
import br.com.cpim.integration.RentalAssembler;
import br.com.cpim.integration.RentalFormInput;
import br.com.cpim.model.Accessory;
import br.com.cpim.model.Rental;
import br.com.cpim.repository.RentalRepository;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

@RunWith(JUnitParamsRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
@Transactional
@ActiveProfiles("test")
public class RentalControllerIT {
	
	private static final String URL_SERVICE = "http://localhost:8080/rental/";
	
	@ClassRule
    public static final SpringClassRule SCR = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();	

	@Inject
	private RentalRepository rentalRepository;
	
	@Inject
	private RentalAssembler rentalAssembler;
	
	private RestTemplate restTemplate = new TestRestTemplate();
	
	@Test
	public void shouldReturnBadRequestStatusCodeWhenPayloadIsNull() {
		RentalFormInput nullFormInput = null;
		
		checkResponseForBadRequest(nullFormInput);
	}
	
	@Test
	public void shouldReturnBadRequestStatusCodeWhenPayloadIsEmpty() {
		RentalFormInput emptyFormInput = new RentalFormInput();
		
		checkResponseForBadRequest(emptyFormInput);
	}
	
	@Test
	@Parameters(method="parametersForBadRequest")
	@TestCaseName("[{index}] {method}: {params}")
	public void shouldReturnBadRequestStatusCodeWhenRequiredParametersAreMissing(
			String brand, String model, String year, Integer[] accessories, String color) {
		
		RentalFormInput formInput = new RentalFormInput(brand, model, year, accessories, color);
		
		checkResponseForBadRequest(formInput);
	}

	public Object parametersForBadRequest() {
        return new Object[] {
        	new RentalFormTemplate().withoutBrand().toObjectArray(),
        	new RentalFormTemplate().withoutModel().toObjectArray(),
        	new RentalFormTemplate().withoutYear().toObjectArray(),
        	new RentalFormTemplate().withoutAccessories().toObjectArray(),
        	new RentalFormTemplate().withoutColor().toObjectArray(),
        	new RentalFormTemplate().withBrand("").toObjectArray(),
        	new RentalFormTemplate().withModel("").toObjectArray(),
        	new RentalFormTemplate().withYear("").toObjectArray(),
        	new RentalFormTemplate().withColor("").toObjectArray(),
        	new RentalFormTemplate().withEmptyAccessories().toObjectArray()
        };
    }
	
	@Test
	@Parameters(method="parametersForOkResponseStatus")
	@TestCaseName("[{index}] {method}: {params}")
	public void shouldReturnOkStatusCodeWhenRequiredParametersAreCorrect(
			String brand, String model, String year, Integer[] accessories, String color) {
		
		RentalFormInput formInput = new RentalFormInput(brand, model, year, accessories, color);
		
		ResponseEntity<RentalFormInput> response = 
				(ResponseEntity<RentalFormInput>) restTemplate.postForEntity(URL_SERVICE, formInput, RentalFormInput.class);
		
		assertThat("Should result in Ok response status",
				response.getStatusCode(), equalTo(HttpStatus.OK));
		assertThat("Should have generated id", response.getBody().getIdRental(), notNullValue());
		assertThat("Should have original value", response.getBody().getIdRental(), notNullValue());
		assertThat("Should have original value", response.getBody().getBrand(), equalTo(formInput.getBrand()));
		assertThat("Should have original value", response.getBody().getModel(), equalTo(formInput.getModel()));
		assertThat("Should have original value", response.getBody().getYear(), equalTo(formInput.getYear()));
		assertThat("Should have original value", response.getBody().getAccessories(), equalTo(formInput.getAccessories()));
		assertThat("Should have original value", response.getBody().getColor(), equalTo(formInput.getColor()));
		
		Rental persistedRental = rentalRepository.findOne(response.getBody().getIdRental());
		assertThat("Should have correctly persisted", persistedRental.getBrand(), equalTo(formInput.getBrand()));
		assertThat("Should have correctly persisted", persistedRental.getModel(), equalTo(formInput.getModel()));
		assertThat("Should have correctly persisted", persistedRental.getYear(), equalTo(formInput.getYear()));
		assertThat("Should have correctly persisted", getAccessoryIdList(persistedRental.getAccessories()), equalTo(Arrays.asList(formInput.getAccessories())));
		assertThat("Should have correctly persisted", persistedRental.getColor(), equalTo(formInput.getColor()));
	}

    public Object parametersForOkResponseStatus() {
        return new Object[] {
        	new RentalFormTemplate().withAccessories(1).toObjectArray(),
        	new RentalFormTemplate().withAccessories(1, 2).toObjectArray(),
        	new RentalFormTemplate().withAccessories(1, 2, 3).toObjectArray(),
        	new RentalFormTemplate().withAccessories(1, 2, 3, 4).toObjectArray()
        };
    }

    private List<Integer> getAccessoryIdList(List<Accessory> accessories) {
    	return rentalAssembler.toAccessoriesIdList(accessories);
	}

	private void checkResponseForBadRequest(RentalFormInput formInput) {
		ResponseEntity<RentalFormInput> response = 
				(ResponseEntity<RentalFormInput>) restTemplate.postForEntity(URL_SERVICE, formInput, RentalFormInput.class);
		
		assertThat("Should result in bad request", 
				response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
	}
	
	class RentalFormTemplate {
		
		private RentalFormInput formInput;
		
		public RentalFormTemplate() {
			formInput = new RentalFormInput(
					"Chevrolet", "Onix", "2015", new Integer[]{1, 2, 3, 4}, "Branco");
		}

		public RentalFormInput getInput() {
			return formInput;
		}
		
		public RentalFormTemplate withoutBrand() {
			formInput.setBrand(null);
			return this;
		}
		
		public RentalFormTemplate withoutModel() {
			formInput.setModel(null);
			return this;
		}
		
		public RentalFormTemplate withoutYear() {
			formInput.setYear(null);
			return this;
		}
		
		public RentalFormTemplate withoutAccessories() {
			formInput.setAccessories(null);
			return this;
		}
		
		public RentalFormTemplate withEmptyAccessories() {
			formInput.setAccessories(new Integer[] {});
			return this;
		}
		
		public RentalFormTemplate withoutColor() {
			formInput.setColor(null);
			return this;
		}
		
		public RentalFormTemplate withBrand(String brand) {
			formInput.setBrand(brand);
			return this;
		}
		
		public RentalFormTemplate withModel(String model) {
			formInput.setModel(model);
			return this;
		}
		
		public RentalFormTemplate withYear(String year) {
			formInput.setYear(year);
			return this;
		}
		
		public RentalFormTemplate withAccessories(Integer... accessories) {
			formInput.setAccessories(accessories);
			return this;
		}
		
		public RentalFormTemplate withColor(String color) {
			formInput.setColor(color);
			return this;
		}
		
		public Object[] toObjectArray() {
			return new Object[] {formInput.getBrand(), 
					formInput.getModel(), formInput.getYear(), formInput.getAccessories(), 
					formInput.getColor()};
		}
	}
}
