package es.rodaja.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rodaja.model.entity.User;
import es.rodaja.model.persistence.DaoUser;

@Service
public class ServiceUser {

	@Autowired
	private DaoUser du;

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
		return response;
	}

	/**
	 * This method returns all the users persisted
	 * @return A list with all the users
	 */
	public List<User> findAll(){
		return du.findAll();
	}
	
	/**
	 * This method finds a user by its ID
	 * @param id The user ID
	 * @return The user with that ID, null if there is no user with that ID
	 */
	public Optional<User> findById(Integer id) {
		return du.findById(id);
	}
	
	/**
	 * This method finds a user by its email
	 * @param email The email of the user
	 * @return The user with that email, null if there is no user with that email
	 */
	public Optional<User> findByEmail(String email) {
		return du.findByEmail(email);
	}
}
