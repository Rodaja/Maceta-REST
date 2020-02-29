package es.rodaja.model.service;

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

}
