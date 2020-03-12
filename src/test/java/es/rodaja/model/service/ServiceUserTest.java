package es.rodaja.model.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.boot.test.context.SpringBootTest;

import es.rodaja.model.entity.FlowerPot;
import es.rodaja.model.entity.User;
import junit.framework.TestCase;

@RunWith(Parameterized.class)
@SpringBootTest
public class ServiceUserTest extends TestCase{

	@Parameters(name = "Usuario: {index}")
	public static Collection<String[]> data() {
		return Arrays.asList(new String[][] { { "examplemail.com", "example", "one", "one", "1234", "spain", "", null },
				{ null, null, null, null, null, null, null, null } });
	}

	// Object from the class to test
	private ServiceUser suTest = new ServiceUser();
	private String email;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String password;
	private String country;
	private String apiKey;

	private List<FlowerPot> listFlowerPots;

	public ServiceUserTest(String email, String name, String firstSurname, String secondSurname, String password,
			String country, String apiKey, List<FlowerPot> listFlowerPots) {
		super();
		this.email = email;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.password = password;
		this.country = country;
		this.apiKey = apiKey;
		this.listFlowerPots = listFlowerPots;
	}

	@Test
	public void saveTest() {
		User user = new User(email, name, firstSurname, secondSurname, password, country, apiKey, listFlowerPots);

		System.out.println(user.toString());
		
		Assert.assertTrue(suTest.save(user));

	}

}
