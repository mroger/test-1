package br.com.cpim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpim.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
