package es.rodaja.model.security;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserSecurityTest {

	final private UserSecurity userSecurityTest = new UserSecurity();

	@Test
	void generateApiKeyTest() {
		String key = userSecurityTest.generateApiKey();

		for (Character c : key.toCharArray()) {
			assertTrue(!Character.isDigit(c));

		}

	}
}
