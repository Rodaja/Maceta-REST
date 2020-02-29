package es.rodaja.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.rodaja.model.entity.FlowerPot;

@Repository
public interface DaoFlowerPot extends JpaRepository<FlowerPot, String>{

	void deleteByMacAddress(String macAddress);
}
