package es.rodaja.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.persistence.DaoFlowerPot;

@Service
public class ServiceFlowerPot {

	@Autowired
	private DaoFlowerPot dfp;

	/**
	 * This method persist a flowerpot <b>only if it has the mac address not
	 * empty</b>
	 * 
	 * @param fp The flowerpot to be persist
	 * @return True if the flowepot has been persisted, false in the opposite case
	 */
	public boolean save(FlowerPot fp) {
		boolean response = false;

		if (checkFlowerPot(fp)) {
			dfp.save(fp);
			response = true;
		}

		return response;
	}

	/**
	 * This method checks if the mac address is not empty
	 * 
	 * @param fp The flowerpot to be checked
	 * @return True if the mac address is not empty, false in the opposite case
	 */
	private boolean checkFlowerPot(FlowerPot fp) {
		boolean response = false;
		String macAddress = fp.getMacAddress();

		if (!macAddress.isEmpty()) {
			response = true;
		}

		return response;
	}

	/**
	 * This method finds all the flowerpots that are persisted
	 * 
	 * @return A list with all the flowerpots
	 */
	public List<FlowerPot> findAll() {
		return dfp.findAll();
	}

	/**
	 * This method finds the flowerpot with the mac address given as a parameter
	 * 
	 * @param macAddress The mac address of the flowerpot
	 * @return The flowerpot with the mac address, null in case there is no
	 *         flowerpot founded
	 */
	public Optional<FlowerPot> findByMacAddress(String macAddress) {
		return dfp.findByMacAddressIgnoreCase(macAddress);
	}

	/**
	 * This method changes an existing flowerpot to the flowerpot given as a
	 * parameter
	 * 
	 * @param fp The new flowerpot
	 * @return True if the flowerpot has changed, false in the opposite case
	 */
	public boolean modify(FlowerPot fp) {
		boolean response = false;

		if (checkFlowerPot(fp)) {
			dfp.save(fp);
			response = true;
		}

		return response;
	}

	/**
	 * This method deletes a flowerpot by its mac address
	 * 
	 * @param id The mac address of the flowerpot to be removed
	 */
	public void delete(String macAddress) {
		dfp.deleteByMacAddressIgnoreCase(macAddress);
	}
}
