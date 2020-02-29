package es.rodaja.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.persistence.DaoFlowerPot;

@Service
public class ServiceFlowerPot {
	
	@Autowired
	private DaoFlowerPot dfp;
	
	/**
	 * This method persist a flowerpot <b>only if it has the mac address not empty</b>
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
	 * This method deletes a flowerpot by its mac address
	 * 
	 * @param id The mac address of the flowerpot to be removed
	 */
	public void delete(String macAddress) {
		dfp.deleteByMacAddress(macAddress);
	}
}
