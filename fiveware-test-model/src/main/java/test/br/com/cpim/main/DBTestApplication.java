package test.br.com.cpim.main;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import br.com.cpim.config.DbConfig;
import br.com.cpim.model.Accessory;
import br.com.cpim.model.Rental;
import br.com.cpim.repository.AccessoryRepository;
import br.com.cpim.repository.RentalRepository;

/**
 * Classe criada para exercitar o banco de dados e os mapeamentos JPA isoladamente da aplicacao.
 * 
 * @author Roger
 *
 */
@Import(DbConfig.class)
@SpringBootApplication
public class DBTestApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DBTestApplication.class);
	
	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private AccessoryRepository accessoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DBTestApplication.class);
	}
	
    @Transactional
    public void run(String... args) throws Exception {
		log.info("Inserting some lines into repository");
		log.info("------------------------------------");
		
		Rental rental = rentalRepository.save(getNewRental());
		log.info("New rental id: {}", rental.getIdRental());
		List<Accessory> accessories = getAccessories();
		rental.setAccessories(accessories);
		rentalRepository.save(rental);
		
		Rental storedRental = rentalRepository.findOne(rental.getIdRental());
		log.info("Stored rental: {}", storedRental);
		
		rentalRepository.delete(rental.getIdRental());
	}

	private Rental getNewRental() {
		Rental rental = new Rental();
		rental.setBrand("Chevrolet");
		rental.setModel("Camaro");
		rental.setYear("2015");
		rental.setColor("Amarelo");
		return rental;
	}

	private List<Accessory> getAccessories() {
		List<Accessory> accessories = new ArrayList<>();
		Accessory accessory = accessoryRepository.findOne(2);
		accessories.add(accessory);
		accessory = accessoryRepository.findOne(3);
		accessories.add(accessory);
		return accessories;
	}
}
