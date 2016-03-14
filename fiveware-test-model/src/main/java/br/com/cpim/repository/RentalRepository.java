package br.com.cpim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cpim.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

}
