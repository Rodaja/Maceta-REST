package es.rodaja.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			checkNullValues(fp);
			dfp.save(fp);
			response = true;
		}

		return response;
	}

	/**
	 * This method check all the null values and gives to them a default one
	 * 
	 * @param fp The flowerpot to check
	 */
	private void checkNullValues(FlowerPot fp) {
		if (fp.getImageUrl() == null) {
			fp.setImageUrl("");
		}

		if (fp.getName() == null) {
			fp.setName("Gardenia");
		}
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
	 * This method deletes a flowerpot by its mac address We use transational to
	 * allow to remove the flowerpot
	 * 
	 * @param id The mac address of the flowerpot to be removed
	 */
	@Transactional
	public void delete(String macAddress) {
		dfp.deleteByMacAddressIgnoreCase(macAddress);
	}

	/**
	 * This method checks that the name and the image URL are not null
	 * @param fpDataBase The flowerpot saved in the database
	 * @param fpModified The flowerpot that has been modified
	 * @return A flowerpot with all the fields updated
	 */
	public FlowerPot checkData(FlowerPot fpDataBase, FlowerPot fpModified) {
		
		if (fpModified.getName() == null) {
			fpModified.setName(fpDataBase.getName());
		}
		if (fpModified.getImageUrl() == null) {
			fpModified.setImageUrl(fpDataBase.getImageUrl());
		}
		return fpModified;

	}

	/**
	 * This method check that the version of the Arduino is the same as the version of the server, it returns true if the Arduino needs an update, false otherwise
	 * @param arduinoVersion The arduino version
	 * @param currentVersion The last version of the code provided by the server
	 * @return True if the arduino needs an update, false otherwises
	 */
	public boolean checkArduinoVersion(String arduinoVersion, String currentVersion) {
		boolean response = false;
		if (!arduinoVersion.equalsIgnoreCase(currentVersion)) {
			response = true;
		} 
		
		return response;
	}



}
