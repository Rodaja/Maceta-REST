package es.rodaja.model.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.rodaja.model.entity.FlowerPot;

@Repository
public interface DaoFlowerPot extends JpaRepository<FlowerPot, String>{

	public void deleteByMacAddressIgnoreCase(String macAddress);
	public Optional<FlowerPot> findByMacAddressIgnoreCase(String macAddress);
}
