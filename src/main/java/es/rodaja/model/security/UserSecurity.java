package es.rodaja.model.security;

import java.util.Random;

public class UserSecurity {
	
	//The length of the API KEY
	private final int API_LENGTH = 30;
	
	/**
	 * This method generates an API KEY with letters between A-Z
	 * @return The generated API KEY
	 */
	public String generateApiKey() {
		
		String key = "";
		
		for (int i = 0; i < API_LENGTH; i++) {
			char letter = (char) (Math.random() * (90 - 65 + 1) + 65);
			key += letter;
		}
		
		return key;
	}

}
