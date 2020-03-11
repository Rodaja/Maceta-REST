package es.rodaja.model.service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.entity.Login;
import es.rodaja.model.entity.User;
import es.rodaja.model.persistence.DaoUser;
import es.rodaja.model.security.UserSecurity;

@Service
public class ServiceUser {

	@Autowired
	private DaoUser du;

	final UserSecurity us = new UserSecurity();

	/**
	 * This method persist a user given by the parameter <b>if it hasn´t the email
	 * and the password empty</b>
	 * 
	 * @param u The user to persist
	 * @return True if the user has been persisted, false in the opposite case
	 */
	public boolean save(User u) {
		boolean response = false;

		if (checkUserData(u)) {
			u.setApiKey(us.generateApiKey());
			du.save(u);
			response = true;
		}

		return response;
	}

	/**
	 * This method checks if the user email and the user password are not empty
	 * 
	 * @param u The user to be checked
	 * @return True if both attributes are not empty, false in the opposite case
	 */
	private boolean checkUserData(User u) {
		String email = u.getEmail();
		String passwd = u.getPassword();
		boolean response = !email.isEmpty() && !passwd.isEmpty() ? true : false;

		// Hash the user password
		u.setPassword(hashPassword(u.getPassword()));

		return response;
	}

	/**
	 * This method hash the user password using SHA256
	 * 
	 * @param password The password to hash
	 * @return The hashed password
	 */
	private String hashPassword(String password) {
		return Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
	}

	/**
	 * This method returns all the users persisted
	 * 
	 * @return A list with all the users
	 */
	public List<User> findAll() {
		return du.findAll();
	}

	/**
	 * This method finds a user by its ID
	 * 
	 * @param id The user ID
	 * @return The user with that ID, null if there is no user with that ID
	 */
	public Optional<User> findById(Integer id) {
		return du.findById(id);
	}

	/**
	 * This method finds a user by its email
	 * 
	 * @param email The email of the user
	 * @return The list of users with that email, empty list if there is no user
	 *         with that email
	 */
	public Optional<User> findByEmail(String email) {
		return du.findByEmail(email);
	}

	/**
	 * This method persist the new user given by the parameter <b>if it hasn´t the
	 * email and the password empty</b>
	 * 
	 * @param u The new user to save
	 * @return True if the new user has been persisted, false in the opposite case
	 */
	public boolean modify(User u) {
		boolean response = false;

		if (checkUserData(u)) {
			du.save(u);
			response = true;
		}

		return response;
	}

	/**
	 * This method deletes a user by its ID
	 * 
	 * @param id The ID of the user to be removed
	 */
	public void delete(Integer id) {
		du.deleteById(id);
	}

	/**
	 * This method adds a flowerpot to a given user
	 * 
	 * @param u The user
	 * @param f The flowerpot to add
	 */
	public void addFlowerPot(User u, FlowerPot f) {
		List<FlowerPot> listFlowerPots = u.getListFlowerPots();
		listFlowerPots.add(f);
		u.setListFlowerPots(listFlowerPots);
		du.save(u);
	}

	/**
	 * This method removes a flowerpot of a user
	 * 
	 * @param u The user
	 * @param f The flowerpot MAC address to remove
	 */
	public void removeFlowerPot(User u, String macAddress) {
		List<FlowerPot> listFlowerPots = u.getListFlowerPots();

		for (FlowerPot flowerPot : listFlowerPots) {
			if (flowerPot.getMacAddress().equalsIgnoreCase(macAddress)) {
				listFlowerPots.remove(flowerPot);
				break;
			}
		}

		u.setListFlowerPots(listFlowerPots);
		du.save(u);
	}

	/**
	 * This method checks that the user and login objects contain the same email and
	 * password
	 * 
	 * @param user  The user persisted
	 * @param login The login object that contains the email and the password
	 * @return An optional with the user if both have the same email and password or
	 *         an optional with null value
	 */

	public Optional<User> checkCredentials(User user, Login login) {
		String email = user.getEmail();

		Optional<User> response = findByEmail(email);

		if (response.isPresent()) {

			String userPassword = user.getPassword();

			login.setPassword(hashPassword(login.getPassword()));

			String loginPassword = login.getPassword();

			if (!userPassword.equals(loginPassword)) {
				response = null;
			}
		}
		return response;
	}

	/**
	 * This method checks the user API KEY and an API KEY given as a parameter
	 * 
	 * @param user The user that contains the valid API KEY
	 * @param key  The API KEY to be checked
	 * @return True if both of them are the same, false in the opposite case
	 */
	public boolean checkApiKey(User user, String key) {
		boolean response = user.getApiKey().equals(key) ? true : false;

		return response;
	}
}
