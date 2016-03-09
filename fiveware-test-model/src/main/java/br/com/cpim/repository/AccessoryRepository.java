package br.com.cpim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cpim.model.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {

}
