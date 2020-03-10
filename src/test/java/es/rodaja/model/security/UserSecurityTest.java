package es.rodaja.model.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserSecurityTest {

	@Test
	void test() {
		UserSecurity security = new UserSecurity();
		
		System.out.println(security.generateApiKey());
	}

}
