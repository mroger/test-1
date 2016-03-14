package br.com.cpim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cpim.model.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Integer> {

}
